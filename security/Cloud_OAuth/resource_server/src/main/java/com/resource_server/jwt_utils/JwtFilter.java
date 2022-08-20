package com.resource_server.jwt_utils;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import com.resource_server.ResourceApplication;


@Component
public class JwtFilter extends OncePerRequestFilter {

	
	private final Logger logger = LoggerFactory.getLogger(ResourceApplication.class);
	
	private JSONObject jsonObject;
	
	private RestTemplate restTemplate;
	
	private HttpHeaders headers;
	
	private String tokenValidationUrl = "http://localhost:8090/validate";
	
	private String tokenValidationUrl1 = "http://localhost:8090/games/getAll";
	
	@Autowired
	public JwtFilter(JSONObject jsonObject, RestTemplate restTemplate, HttpHeaders headers) {
		this.jsonObject = jsonObject;
		this.restTemplate = restTemplate;
		this.headers = headers;
	}

	
	public JwtFilter() {
	
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		
		String tokenHeader = request.getHeader("Authorization");
	
		String token = null;

		JSONObject tokenBody;
		
		String result = null;

		try {
					   
		    token = tokenHeader.substring(7);
		    
		    JSONObject jsonObj = new JSONObject(); 
		    		    
		    tokenBody = jsonObject.put("token", token);
		    
		    HttpHeaders headers = new HttpHeaders();
		    
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    		    
		    HttpEntity<String> entity =  new HttpEntity<String>(tokenBody.toString(), headers);
			       	  
		    
		    
//    	    result = restTemplate.postForObject(tokenValidationUrl ,request, String.class);
			
//		    result = restTemplate.exchange("tokenValidationUrl", HttpMethod.GET, entity, String.class).getBody();

		    
		    RestTemplate restTemplate = new RestTemplate();
		    
		    HttpEntity<String> entity1 =  new HttpEntity<String>( headers);
		    
		    restTemplate.exchange("tokenValidationUrl1", HttpMethod.GET, entity1, String.class).getBody();
		    
		    
//		    token = tokenHeader.substring(7);
//		   	    
//		    tokenBody = jsonObject.put("token", token);
//		    
//		    HttpEntity<String> entity =  new HttpEntity<String>(tokenBody.toString(), headers);
//			       	    
//    	    result = restTemplate.postForObject(tokenValidationUrl ,request, String.class);
//					    
//		    result = restTemplate.exchange("tokenValidationUrl", HttpMethod.GET, entity, String.class).getBody();
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
			
		} catch (RuntimeException e) {
			throw new RuntimeException("token validation failed");
		} finally {
			
			logger.info(result);
			
			logger.info(token);
			
			logger.info(request.getHeader("Authorization"));
		}
		

		
	}



}
