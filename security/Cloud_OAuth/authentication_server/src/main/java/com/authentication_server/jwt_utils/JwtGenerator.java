package com.authentication_server.jwt_utils;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
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

	public String generateToken(String subject, Map<String, String> claims) {
		Builder builder = JWT.create().withSubject(subject);
		return builder.withIssuedAt(new Date())
				.withExpiresAt(new Date(System.currentTimeMillis()+tokenExpirationDuration))
				.withClaim("", "")
				.sign(Algorithm.HMAC256(jwtSecret));
	}
	
	
}
