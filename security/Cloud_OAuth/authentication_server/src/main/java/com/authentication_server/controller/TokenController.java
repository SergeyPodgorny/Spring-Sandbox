package com.authentication_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.authentication_server.dto.TokenRequestDTO;
import com.authentication_server.dto.TokenResponseDTO;
import com.authentication_server.service.TokenService;

@RestController
public class TokenController {
	
	
	private final TokenService tokenService;
	
	@Autowired
	public TokenController(TokenService tokenService) {
		this.tokenService = tokenService;
	}




	@GetMapping("/token")
	public ResponseEntity<TokenResponseDTO> getToken(@RequestBody TokenRequestDTO tokenRequest) {
				
		String token = tokenService.generateToken(tokenRequest.getUsername(), tokenRequest.getPassword());
				
		return ResponseEntity.ok(new TokenResponseDTO(token));
	}
	
	
}
