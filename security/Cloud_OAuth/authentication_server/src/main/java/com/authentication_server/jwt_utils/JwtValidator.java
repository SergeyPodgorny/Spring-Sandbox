package com.authentication_server.jwt_utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import com.authentication_server.AuthApplication;






@Component
public class JwtValidator {
	

	
	private final Logger logger = LoggerFactory.getLogger(AuthApplication.class);
	
	
	@Value("${variable.settings.security.secret}")
	private String jwtSecret;
	
	
	public Boolean validateToken(String token) {
		
		verifyToken(token);
		
		String username = getUsernameFromToken(token);
		DecodedJWT parsedToken = parseToken(token);
		Boolean isTokenValid = false;
		Boolean isTokenExpired = parsedToken.getExpiresAt().after(parsedToken.getIssuedAt());
		Boolean isUsernameValid = parsedToken.getSubject().equals(username);
		
		
		
		if (isTokenExpired && isUsernameValid) {
			isTokenValid = true;
		} else {
			isTokenValid = false;
		}
		return isTokenValid;
				
	}

	
	
	private String getUsernameFromToken(String token) {
		return parseToken(token).getSubject();
	}
	
	
	private void verifyToken(String token) {
		
		try {
			Verification verifier = JWT.require(Algorithm.HMAC256(jwtSecret));
			
			verifier.build().verify(parseToken(token));
			logger.warn("token verification for user: "+ getUsernameFromToken(token) +"succesfully");
		} catch (Exception e) {
			logger.error("token verification for user: "+ getUsernameFromToken(token) +"failed");
			e.printStackTrace();
			
		}
		
		

	}
	
	
	private DecodedJWT parseToken(String token) {
		return JWT.decode(token);
	}

}
