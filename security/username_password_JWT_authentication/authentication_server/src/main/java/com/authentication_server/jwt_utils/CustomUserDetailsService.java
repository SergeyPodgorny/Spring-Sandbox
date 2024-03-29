package com.authentication_server.jwt_utils;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;


import com.authentication_server.entity.Account;
import com.authentication_server.repository.AccountRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService{

	
	private final AccountRepository accountReposiory;
	
	
	@Autowired
	public CustomUserDetailsService(AccountRepository accountReposiory) {
		this.accountReposiory = accountReposiory;
	}


	@Override
	public UserDetails loadUserByUsername(String username) {
		final Account userAccount = accountReposiory.findUserByUsername(username).get();
		return new User(userAccount.getUsername(),userAccount.getPassword(), new ArrayList<>());
	}

}
