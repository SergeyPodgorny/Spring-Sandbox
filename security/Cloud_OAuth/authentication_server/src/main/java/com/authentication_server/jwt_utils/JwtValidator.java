package com.authentication_server.jwt_utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;

import com.auth0.jwt.interfaces.DecodedJWT;






@Component
public class JwtValidator {
	
	@Value("${variable.settings.security.secret}")
	private String jwtSecret;
	
		
	public Boolean validateToken(String token, String username) {
			
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

	
	
	public String getUsernameFromToken(String token) {
				
		return parseToken(token).getClaim("username").asString();
	}
	
	
	
	private DecodedJWT parseToken(String token) {
		return JWT.decode(token);
	}

}
