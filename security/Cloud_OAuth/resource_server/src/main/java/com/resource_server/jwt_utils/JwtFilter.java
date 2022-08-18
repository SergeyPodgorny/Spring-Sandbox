package com.resource_server.jwt_utils;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import com.resource_server.ResourceApplication;


@Component
public class JwtFilter extends OncePerRequestFilter {

	
	private final Logger logger = LoggerFactory.getLogger(ResourceApplication.class);
	
	
	private RestTemplate restTemplate;
	
	@Autowired
	public JwtFilter(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		
		String tokenHeader = request.getHeader("Authorization");
		
		String token;
		
		Boolean isTokenValid;
		
		HttpEntity<String> request1;
		
		ResponseEntity<String> response1;
		
		
		if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
			token = tokenHeader.substring(7);
		} else throw new RuntimeException("Request doesn't contain any suitable header");
		
		
		try {
			
//			HttpHeaders headers = new HttpHeaders();
//			
//			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//			
//			HttpEntity<Boolean> entity = new HttpEntity<>(headers);	
			
//			isTokenValid = restTemplate.exchange("http://localhost:8090/validate", HttpMethod.GET, entity, Boolean.class).getBody();
			
			request1 = new HttpEntity<>(token);
			
			response1 = restTemplate.postForEntity("http://localhost:8090/validate", request1, String.class);
			
		} catch (RuntimeException e) {
			throw new RuntimeException("token validation failed");
		}
		
		logger.info(response1.toString());
		
		logger.info(token);
		
		logger.info(request.getHeader("Authorization"));
		
	}

}
