package com.authentication_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.authentication_server.dto.TokenRequestDTO;
import com.authentication_server.service.TokenService;

@RestController
public class TokenController {
	
	
	private final TokenService tokenService;
	
	@Autowired
	public TokenController(TokenService tokenService) {
		this.tokenService = tokenService;
	}




	@GetMapping("/token")
	public String getToken(@RequestBody TokenRequestDTO tokenRequest) {
		return tokenService.generateToken(tokenRequest.getUsername());
	}
	
	
}
