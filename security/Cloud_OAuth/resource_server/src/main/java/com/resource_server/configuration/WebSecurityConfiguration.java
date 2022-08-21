package com.resource_server.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.resource_server.jwt_utils.JwtFilter;

@Configuration
public class WebSecurityConfiguration {
	
	@Autowired
	JwtFilter jwtFilter;
	
	
	
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception {
		
//		http.authorizeRequests().antMatchers("/login", "/validate").permitAll()
//		.anyRequest().authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		
		
		
		return http.build();
	}
	
	

}
