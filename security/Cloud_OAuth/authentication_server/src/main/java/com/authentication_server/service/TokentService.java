package com.authentication_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.authentication_server.jwt_utils.JwtGenerator;

@Service
@CrossOrigin
public class TokentService {
	
	
	
	
	@Autowired
	private JwtGenerator jwtGenerator;
	
	
	public String generateToken() {
		return "";
	}
	
	
	
	
	
	
	

}
