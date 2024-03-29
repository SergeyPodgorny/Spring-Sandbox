package com.resource_server.jwt_utils;

import java.io.IOException;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
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
		
//		String tokenHeader = request.getHeader("Authorization");
//		
//		logger.warn("incoming token: "+ tokenHeader);
		
		
		try {
		RequestAttributes attribs = RequestContextHolder.getRequestAttributes();
        if (attribs != null) {
            HttpServletRequest request1 = ((ServletRequestAttributes) attribs).getRequest();
            logger.info(request1.getHeader("Authorization"));
            
    
        }
		} catch (RuntimeException e) {
			logger.info("=======================APP CRASHED======================");
		}
		
		
//	    
//	    String tokenHeader= "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY2MzY5MjI2NSwiaWF0IjoxNjYzNjkxNzY1fQ.kJBPSPa-9E5NdU0CUq_5loIhp8mZNLHB2Ud-Vd8mkIQ";
//	    
//	    String token = tokenHeader.substring(7);
//	    	    
//	    logger.warn("incoming token: "+token);
//	    
//	    logger.warn("incoming token_header: "+ tokenHeader);
//	    
//	    headers.add("token", token);
//	    
//	    HttpEntity<Boolean> httpEntity =  new HttpEntity<Boolean>(headers);
//	    
//	    Boolean isTokenValid = restTemplate.exchange(tokenValidationUrl, HttpMethod.POST, httpEntity, Boolean.class).getBody();
//	    
//	    headers.remove("token");
//	    
//	    logger.info(isTokenValid.toString());
	    
		filterChain.doFilter(request, response);
	    
//	    
//	    Boolean isTokenValid =true;		
		
//	    if (isTokenValid) {
//	    	
//	    	filterChain.doFilter(request, response);
//	    	
//	    } else throw new RuntimeException("token validation failed");
	    
	}
	
	




}
