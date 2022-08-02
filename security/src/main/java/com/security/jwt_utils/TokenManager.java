package com.security.jwt_utils;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class TokenManager implements Serializable{

	
	
	
	@Value("${secret}")
	private String jwtSecret;
	private static final long serialVersionUID = 1L;
	
	
	
	
	

}
