package com.banking.service.common;

import org.springframework.beans.factory.annotation.Value;

public class JWTAuthenticationConfig {

	@Value("${bank.security.jwt.url:/login}")
	private String url;

	@Value("${bank.security.jwt.header:Authorization}")
	private String header;

	@Value("${bank.security.jwt.prefix:Bearer}")
	private String prefix;

	@Value("${bank.security.jwt.expiration:#{2*60}}")
	private int expiration; // default 2 minutes

	@Value("${bank.security.jwt.secret}")
	private String secret;

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @return the header
	 */
	public String getHeader() {
		return header;
	}

	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * @return the expiration
	 */
	public int getExpiration() {
		return expiration;
	}

	/**
	 * @return the secret
	 */
	public String getSecret() {
		return secret;
	}
	
}
