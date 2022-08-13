package com.authentication_server.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.authentication_server.jwt_utils.JwtGenerator;

@Service
@CrossOrigin
public class TokenService {
	
	
	
	private final JwtGenerator jwtGenerator;
	
	private final CustomUserDetailsService userDetails;
	
	@Autowired
	public TokenService(JwtGenerator jwtGenerator, CustomUserDetailsService userDetails) {
		this.jwtGenerator = jwtGenerator;
		this.userDetails = userDetails;
	}



	public String generateToken(String username) {
		
		
		
		return jwtGenerator.generate(userDetails.loadUserByUsername(username));
	}

	
	
	
	
	
	

}
