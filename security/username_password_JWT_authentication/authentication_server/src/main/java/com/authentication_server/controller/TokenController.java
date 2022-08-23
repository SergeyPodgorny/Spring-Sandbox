package com.authentication_server.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.authentication_server.AuthApplication;
import com.authentication_server.dto.TokenRequestDTO;
import com.authentication_server.dto.TokenResponseDTO;
import com.authentication_server.jwt_utils.JwtValidator;
import com.authentication_server.service.TokenService;

@RestController
@CrossOrigin
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
	public Boolean validateToken(HttpServletRequest request) {
		String incomingToken = request.getHeader("token");	
		
		logger.info("incoming token: "+ request.getHeader("token"));
			
		Boolean isIncomingTokenValid = jwtValidator.validateToken(incomingToken);
				
		return isIncomingTokenValid;
		
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		return tokenService.removeUserFromSession(request.getHeader("token"));
	}
	
	
}
