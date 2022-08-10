package com.authentication_server.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.authentication_server.dto.TokenRequestDTO;
import com.authentication_server.dto.TokenResponseDTO;
import com.authentication_server.jwt_utils.JwtGenerator;

@Service
@CrossOrigin
public class TokenService {
	
	private final UserDetailsService userDetailsService;
	
	private final JwtGenerator jwtGenerator;
	
	@Autowired
	public TokenService(UserDetailsService userDetailsService, JwtGenerator jwtGenerator) {
		this.userDetailsService = userDetailsService;
		this.jwtGenerator = jwtGenerator;
	}
	

	public String generateToken(TokenRequestDTO tokenRequest) {
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(tokenRequest.getUsername());
		
		return jwtGenerator.generate(userDetails);
	}

	
	
	
	
	
	

}
