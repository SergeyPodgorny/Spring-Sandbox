package com.security.service;

import org.springframework.stereotype.Service;

import com.security.entity.Account;
import com.security.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.security.core.userdetails.User; 

@Service
public class JwtUserDetailsService implements UserDetailsService{

	@Autowired
	private final AccountRepository accountReopsitory;
		
		
	public JwtUserDetailsService(AccountRepository accountReopsitory) {
		this.accountReopsitory = accountReopsitory;
	}




	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Account foundUserByUsername = accountReopsitory.findUserByUsername(username).get();
		return new User(foundUserByUsername.getUsername(), foundUserByUsername.getPassword(), new ArrayList<>());
	}
	

	
	
	
	
	
	
}
