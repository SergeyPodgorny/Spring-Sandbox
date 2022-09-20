package com.authentication_server.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebSecurityConfiguration {

	
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/login", "/validate", "/logout").permitAll()
		.anyRequest().authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);		

		http.csrf().disable();
		
//		http.cors();
	

		
		return http.build();
	}
	
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	 @Bean
	 public PasswordEncoder passwordEncoder() {
	     return new BCryptPasswordEncoder();
	 }
	
	
}
