package com.authentication_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authentication_server.jwt_utils.JwtGenerator;
import com.authentication_server.service.TokenService;

@RestController
public class TokenController {
	
	
	private final TokenService tokenService;
	
	@Autowired
	public TokenController(TokenService tokenService) {
		this.tokenService = tokenService;
	}




	@GetMapping("/token")
	public String getToken(String subject) {
		return tokenService.generateToken(subject);
	}
	
	
}
