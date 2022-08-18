package com.authentication_server.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.authentication_server.AuthApplication;
import com.authentication_server.jwt_utils.CustomUserDetailsService;
import com.authentication_server.jwt_utils.JwtGenerator;
import com.authentication_server.jwt_utils.JwtValidator;


@Service
@CrossOrigin
public class TokenService {
	
	private final Logger logger = LoggerFactory.getLogger(AuthApplication.class);
	
	private final JwtGenerator jwtGenerator;
	
	private final CustomUserDetailsService userDetails;
	
//	private final AuthenticationManager authenticationManager;
	
	private final JwtValidator jwtValidator;
	
	
	
	
	@Autowired
	public TokenService(JwtGenerator jwtGenerator, CustomUserDetailsService userDetails, JwtValidator jwtValidator) {
		this.jwtGenerator = jwtGenerator;
		this.userDetails = userDetails;
		this.jwtValidator = jwtValidator;
}

//	@Autowired
//	public TokenService(JwtGenerator jwtGenerator, CustomUserDetailsService userDetails,
//			AuthenticationManager authenticationManager, JwtValidator jwtValidator) {
//		this.jwtGenerator = jwtGenerator;
//		this.userDetails = userDetails;
//		this.authenticationManager = authenticationManager;
//		this.jwtValidator = jwtValidator;
//	}




	public String generateToken(String username, String password) {
		
		
		UsernamePasswordAuthenticationToken authToken =  new UsernamePasswordAuthenticationToken(username,password);
		
		SecurityContextHolder.getContext().setAuthentication(authToken);
		
//		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
		
		logger.info(SecurityContextHolder.getContext().getAuthentication().toString());
				
		logger.info(username + " "+ " " + password);
		
		return jwtGenerator.generate(userDetails.loadUserByUsername(username));
	}

	public Boolean validateToken(String token) {
		return jwtValidator.validateToken(token);
	}

	
	

}
