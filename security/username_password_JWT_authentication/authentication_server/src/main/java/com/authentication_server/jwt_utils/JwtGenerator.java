package com.authentication_server.jwt_utils;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;



@Component
public class JwtGenerator {

	@Value("${variable.settings.security.access_secret}")
	private String jwtAccessSecret;
	
	@Value("${variable.settings.security.access_expiration}")
	private Long accessTokenExpirationDuration;	
	
	
	@Value("${variable.settings.security.refresh_secret}")
	private String jwtRefreshSecret;
	
	@Value("${variable.settings.security.refresh_expiration}")
	private Long refreshTokenExpirationDuration;	
	
	

	public String generateAccessToken(UserDetails userDetails) {
		Builder builder = JWT.create().withSubject(userDetails.getUsername());
		
		return builder.withIssuedAt(new Date()).withExpiresAt(new Date(System.currentTimeMillis() + accessTokenExpirationDuration))
				.withSubject(userDetails.getUsername())
				.sign(Algorithm.HMAC256(jwtAccessSecret));
	}
	

	
	
}
