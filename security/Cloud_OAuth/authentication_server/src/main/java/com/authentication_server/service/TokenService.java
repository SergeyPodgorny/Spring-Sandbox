package com.authentication_server.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.authentication_server.jwt_utils.JwtGenerator;

@Service
@CrossOrigin
public class TokenService {
	
	
	
	private final JwtGenerator jwtGenerator;
	
	private final CustomUserDetailsService userDetails;
	
	private final AuthenticationManager authenticationManager;
	
	@Autowired
	public TokenService(JwtGenerator jwtGenerator, CustomUserDetailsService userDetails, AuthenticationManager authenticationManager) {
		this.jwtGenerator = jwtGenerator;
		this.userDetails = userDetails;
		this.authenticationManager = authenticationManager;
	}



	public String generateToken(String username, String password) {
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
		
		
		return jwtGenerator.generate(userDetails.loadUserByUsername(username));
	}



	
	
	
	
	
	

}
