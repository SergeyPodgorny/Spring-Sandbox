package com.authentication_server.jwt_utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;



@Component
public class JwtGenerator {

	@Value("${variable.settings.security.secret}")
	private String jwtSecret;
	
	
	@Value("${variable.settings.security.expiration}")
	private Long tokenExpirationDuration;	

	public String generate(UserDetails userDetails) {
		Builder builder = JWT.create().withSubject(userDetails.getUsername());
		
		Map<String,String> claims = new HashMap<>();
		
		claims.put("token_Expiration_Date", new Date(System.currentTimeMillis() + tokenExpirationDuration).toString());
		
//		claims.entrySet().parallelStream().forEachOrdered((entry)->{
//			String key = entry.getKey();
//			String value = entry.getValue();
//		});
	
		return builder.withIssuedAt(new Date()).withPayload(claims)
				
				.withExpiresAt(new Date(System.currentTimeMillis() + tokenExpirationDuration)).sign(Algorithm.HMAC256(jwtSecret));
	}
	
	
}
