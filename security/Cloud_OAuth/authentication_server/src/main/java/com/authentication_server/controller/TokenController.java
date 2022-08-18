package com.authentication_server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.authentication_server.AuthApplication;
import com.authentication_server.dto.TokenRequestDTO;
import com.authentication_server.dto.TokenResponseDTO;
import com.authentication_server.dto.TokenValidationRequestDTO;
import com.authentication_server.dto.TokenValidationResponseDTO;
import com.authentication_server.jwt_utils.JwtValidator;
import com.authentication_server.service.TokenService;

@RestController
public class TokenController {
	
	private final Logger logger = LoggerFactory.getLogger(AuthApplication.class);
	
	private final JwtValidator jwtValidator;
	
	private final TokenService tokenService;
	
	
	@Autowired
	public TokenController(JwtValidator jwtValidator, TokenService tokenService) {
		this.jwtValidator = jwtValidator;
		this.tokenService = tokenService;
	}




	@GetMapping("/login")
	public ResponseEntity<TokenResponseDTO> getToken(@RequestBody TokenRequestDTO tokenRequest) {
				
		String token = tokenService.generateToken(tokenRequest.getUsername(), tokenRequest.getPassword());
		
		return ResponseEntity.ok(new TokenResponseDTO(token));
	}
	
	
	@GetMapping("/validate")
	public ResponseEntity<TokenValidationResponseDTO> validateToken(@RequestBody TokenValidationRequestDTO tokenDTO) {
	
		return ResponseEntity.ok(new TokenValidationResponseDTO(jwtValidator.validateToken(tokenDTO.getToken())));
		
	}
	
	
	
	
}
