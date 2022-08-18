package com.resource_server.jwt_utils;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.resource_server.ResourceApplication;


@Component
public class JwtFilter extends OncePerRequestFilter {

	
	private final Logger logger = LoggerFactory.getLogger(ResourceApplication.class);
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		
		String tokenHeader = request.getHeader("Authorization");
		
		
		
		if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
			String token = tokenHeader.substring(7);
		} else throw new RuntimeException("Request doesn't contain any suitable header");
		
		
		
		logger.info(request.getHeader("Authorization"));
		
	}

}
