package com.redis.redis.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SessionConfiguration {
	
	
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
				
		return http.build();
		
	}
	

}
