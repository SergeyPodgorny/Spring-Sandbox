package com.resource_server.jwt_utils;

import java.io.IOException;

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
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import com.resource_server.ResourceApplication;


@Component
public class JwtFilter extends OncePerRequestFilter {

	private final Logger logger = LoggerFactory.getLogger(ResourceApplication.class);
	
	private RestTemplate restTemplate;

	private HttpHeaders headers;
	
	

	@Autowired
	public JwtFilter(RestTemplate restTemplate, HttpHeaders headers) {
		this.restTemplate = restTemplate;
		this.headers = headers;
	}


	public JwtFilter() {
	
	}
	
	private String tokenValidationUrl = "http://localhost:8090/validate";

	
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		
		String tokenHeader = request.getHeader("Authorization");
		
	    String token = tokenHeader.substring(7);
	    
	    logger.info("incoming token: "+token);
	    
	    headers.add("token", token);
	    
	    HttpEntity<Boolean> httpEntity =  new HttpEntity<Boolean>(headers);
	    
	    Boolean isTokenValid = restTemplate.exchange(tokenValidationUrl, HttpMethod.GET, httpEntity, Boolean.class).getBody();
	    
	    headers.remove("token");
	    
	    if (isTokenValid) {
	    	
	    	filterChain.doFilter(request, response);
	    	
	    } else throw new RuntimeException("token validation failed");
	    
	}
	
	

}