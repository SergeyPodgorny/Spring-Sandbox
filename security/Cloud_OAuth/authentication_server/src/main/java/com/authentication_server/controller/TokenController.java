package com.authentication_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authentication_server.jwt_utils.JwtGenerator;

@RestController
public class TokenController {

	
	
	
	@GetMapping("/token")
	public String getToken() {
		return "token";
	}
	
	
}
