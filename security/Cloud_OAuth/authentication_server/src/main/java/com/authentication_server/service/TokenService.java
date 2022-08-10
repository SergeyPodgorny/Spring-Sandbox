package com.authentication_server.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.authentication_server.jwt_utils.JwtGenerator;

@Service
@CrossOrigin
public class TokenService {
	
			
	private final JwtGenerator jwtGenerator;
	
	
	@Autowired
	public TokenService(JwtGenerator jwtGenerator) {
		this.jwtGenerator = jwtGenerator;
	}

	public String generateToken(String subject) {
		return jwtGenerator.generate(subject);
	}
	
	
	
	
	
	
	

}
