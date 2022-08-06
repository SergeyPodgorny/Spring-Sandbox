package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.dto.JwtRequestDTO;
import com.security.dto.JwtResponseDTO;
import com.security.jwt_utils.TokenManager;
import com.security.service.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtController {

	@Autowired
	private final AuthenticationManager authenticationManager;; 
	
	@Autowired
	private final JwtUserDetailsService jwtUserDetailService;
	
	@Autowired
	private final TokenManager tokenManager;
	
		
	public JwtController(AuthenticationManager authenticationManager, JwtUserDetailsService jwtUserDetailService,
			TokenManager tokenManager) {
		this.authenticationManager = authenticationManager;
		this.jwtUserDetailService = jwtUserDetailService;
		this.tokenManager = tokenManager;
	}

	@GetMapping(value = "/login")
	public JwtResponseDTO createToken(@RequestBody JwtRequestDTO jwtRequestDTO) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequestDTO.getUsername(),jwtRequestDTO.getPassword()));
		} catch (DisabledException e) {
			throw new Exception("ACCOUNT_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception ("BAD_CREDENTIALS", e);
		}
		final UserDetails userDetails = jwtUserDetailService.loadUserByUsername(jwtRequestDTO.getUsername());
		return new JwtResponseDTO (tokenManager.generateToken(userDetails));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
