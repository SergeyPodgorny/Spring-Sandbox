package com.security.jwt_utils;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.security.SecurityApplication;
import com.security.service.JwtUserDetailsService;

import io.jsonwebtoken.ExpiredJwtException;


@Component
public class JwtFilter extends OncePerRequestFilter{
	
	private Logger logger = LoggerFactory.getLogger(SecurityApplication.class);
	
	@Autowired
	private final JwtUserDetailsService jwtUserDetailsService;
	
	@Autowired
	private final TokenManager tokenManager;
	
	
	public JwtFilter(JwtUserDetailsService jwtUserDetailsService, TokenManager tokenManager) {
		this.jwtUserDetailsService = jwtUserDetailsService;
		this.tokenManager = tokenManager;
	}




	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String tokenHeader = request.getHeader("Authorization");
		String username = null;
		String token = null;
		
		if (tokenHeader !=null && tokenHeader.startsWith("Bearer ")) {
			token = tokenHeader.substring(7);
			try {
				username = tokenManager.getUsernameFromToken(token);
			} catch (IllegalArgumentException e) {
				logger.error("Unable to get jwt token");
			}  catch (ExpiredJwtException e) {
				logger.error("JWT Token has expired");	
         }
      } else {
    	  logger.error("Bearer String not found in token");
      }
		
		if (username !=null  && SecurityContextHolder.getContext().getAuthentication() !=null) {
			
			UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);
			
			if (tokenManager.validateToken(token, userDetails)) {
				 UsernamePasswordAuthenticationToken authToken 
				 = new  UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()); // credentials are null for now
				 authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				 SecurityContextHolder.getContext().setAuthentication(authToken);
	 
			}
			
		      filterChain.doFilter(request, response);
			
		}
		
		
		
		
	}

	
	
}
