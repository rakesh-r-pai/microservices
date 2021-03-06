package com.banking.service.common;

import java.io.IOException;
import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	private final JWTAuthenticationConfig config;
	private final ObjectMapper mapper;

	public JWTUsernamePasswordAuthenticationFilter(JWTAuthenticationConfig config, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(config.getUrl(), "POST"));
		setAuthenticationManager(authManager);
		this.config = config;
		this.mapper = new ObjectMapper();
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		User user = mapper.readValue(request.getInputStream(), User.class);
		return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),
				user.getPassword(), Collections.emptyList()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain, Authentication auth) {
		Instant now = Instant.now();
		String token = Jwts.builder().setSubject(auth.getName())
				.claim("authorities",
						auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(Date.from(now)).setExpiration(Date.from(now.plusSeconds(config.getExpiration())))
				.signWith(SignatureAlgorithm.HS256, config.getSecret().getBytes()).compact();
		response.addHeader(config.getHeader(), config.getPrefix() + " " + token);
	}
}
