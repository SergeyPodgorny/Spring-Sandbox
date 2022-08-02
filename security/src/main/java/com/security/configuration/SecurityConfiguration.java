package com.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfiguration {
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{		
		return null;
	}
	
	
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	

}
