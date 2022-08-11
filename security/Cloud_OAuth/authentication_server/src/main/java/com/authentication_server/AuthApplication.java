package com.authentication_server;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.authentication_server.jwt_utils.JwtGenerator;

@SpringBootApplication
public class AuthApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);

	}

	
	
	@Value("${variable.settings.security.secret}")
	private String jwtSecret;
	
	
	@Value("${variable.settings.security.expiration}")
	private Long tokenExpirationDuration;	
	
	
	@Autowired
	JwtGenerator jwtGenerator;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		

		
	}
	
	
	
	
}
