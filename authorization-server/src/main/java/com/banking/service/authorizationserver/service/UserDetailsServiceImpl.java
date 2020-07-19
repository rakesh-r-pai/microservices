package com.banking.service.authorizationserver.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.banking.service.authorizationserver.dao.BankUserRepository;
import com.banking.service.authorizationserver.dao.entity.BankUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private BankUserRepository bankUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		BankUser bankUser = bankUserRepository.findByUsername(username);
		if (bankUser == null) {
			throw new UsernameNotFoundException(username);
		}
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		list.add(new SimpleGrantedAuthority(bankUser.getRole()));
		return new User(bankUser.getUsername(), bankUser.getPassword(), list);
	}

}
