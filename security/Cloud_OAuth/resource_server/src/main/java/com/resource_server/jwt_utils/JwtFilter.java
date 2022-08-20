package com.resource_server.jwt_utils;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
	
	private String tokenValidationUrl = "http://localhost:8090/validate";
	
	private String tokenValidationUrl1 = "http://localhost:8080/hello";

		
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

		
		logger.info("request filtered");
		
		HttpHeaders headers = new HttpHeaders();
		
	    RestTemplate restTemplate = new RestTemplate();
	    
	    HttpEntity<String> entity1 =  new HttpEntity<String>(headers);
	    
	    logger.info(restTemplate.exchange(tokenValidationUrl1, HttpMethod.GET, entity1, String.class).getBody());
	    
	    
		
//	    restTemplate.postForObject(tokenValidationUrl1 ,request, String.class);
		
		filterChain.doFilter(request, response);
		
		
		
	}
	
	
	


//
//
//	
//	public JwtFilter() {
//	
//	}
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//		
////		String tokenHeader = request.getHeader("Authorization");
////	
////		String token = null;
////
////		JSONObject tokenBody;
////		
////		String result = null;
//
//		
//		HttpHeaders headers = new HttpHeaders();
//		
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		
//		HttpEntity <String> entity = new HttpEntity<String>(headers);
//		
//		RestTemplate restTemplate = new RestTemplate();
//		
//		restTemplate.exchange("http://localhost:8080/products", HttpMethod.GET, entity, String.class).getBody();
//		
//		logger.info("request filtered");
//		
//		
//		
//	}
		
		
		
		
		
//		try {
					   
//		    token = tokenHeader.substring(7);
//		    
//		    JSONObject jsonObj = new JSONObject(); 
//		    		    
//		    tokenBody = jsonObject.put("token", token);
//		    
//		    HttpHeaders headers = new HttpHeaders();
//		    
//		    headers.setContentType(MediaType.APPLICATION_JSON);
//		    		    
//		    HttpEntity<String> entity =  new HttpEntity<String>(tokenBody.toString(), headers);
//			       	  
		    
		    
//    	    result = restTemplate.postForObject(tokenValidationUrl ,request, String.class);
			
//		    result = restTemplate.exchange("tokenValidationUrl", HttpMethod.GET, entity, String.class).getBody();

//		    
//		    RestTemplate restTemplate = new RestTemplate();
//		    
//		    HttpEntity<String> entity1 =  new HttpEntity<String>( headers);
//		    
//		    restTemplate.exchange("tokenValidationUrl1", HttpMethod.GET, entity1, String.class).getBody();
		    
		    
//		    token = tokenHeader.substring(7);
//		   	    
//		    tokenBody = jsonObject.put("token", token);
//		    
//		    HttpEntity<String> entity =  new HttpEntity<String>(tokenBody.toString(), headers);
//			       	    
//    	    result = restTemplate.postForObject(tokenValidationUrl ,request, String.class);
//					    
//		    result = restTemplate.exchange("tokenValidationUrl", HttpMethod.GET, entity, String.class).getBody();
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
			
//		} catch (RuntimeException e) {
//			throw new RuntimeException("token validation failed");
//		} finally {
//			
//			logger.info(result);
//			
//			logger.info(token);
//			
//			logger.info(request.getHeader("Authorization"));
//		}
		

		
//	}

	

}
