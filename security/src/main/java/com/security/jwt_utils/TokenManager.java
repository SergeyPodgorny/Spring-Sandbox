package com.security.jwt_utils;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys; 
@Component
public class TokenManager {

	
	@Value("${secret}")
	private String jwtSecret;
	@Value("${expiration_time}")
	private long token_exp_time;
	
	
	
	
	public String generateToken(UserDetails userService) {
		Map<String, Object> claims = new HashMap<>();
		return Jwts.builder().setClaims(claims)
				.setSubject(userService.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+token_exp_time)).signWith(convertStringToKey(jwtSecret)).compact();
	}
	
	
	private Key convertStringToKey(String secret) {
		byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	
	
	
	
	

}
