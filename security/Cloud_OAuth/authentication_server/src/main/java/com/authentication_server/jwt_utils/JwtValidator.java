package com.authentication_server.jwt_utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Verification;






@Component
public class JwtValidator {
	
	
	
	@Value("${variable.settings.security.secret}")
	private String jwtSecret;
	
		
	public Boolean validateToken(String token, String username) {
		
//		Verification tokenParse = JWT.require(Algorithm.HMAC256(jwtSecret));
		
//		return tokenParse.withIssuer(username);
		
				
		return JWT.decode(token).getIssuer().equals("admin");
		

	}


	
	

}
