package com.redis.redis.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.redis.RedisApplication;

@RestController
public class Controller {

	
	private final Logger logger = LoggerFactory.getLogger(RedisApplication.class);
	
	
	@GetMapping("/")
	public String test(HttpSession session) {
		
		session.setAttribute("username", "admin");
		
		logger.info(session.getAttribute("username").toString());
		
		logger.info(session.getId());
		
		return "OK";
	}

	
}
