package com.redis.redis.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.redis.MessageDTO;
import com.redis.redis.RedisApplication;

@RestController
public class Controller {

	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	private final Logger logger = LoggerFactory.getLogger(RedisApplication.class);
	
	
	@GetMapping("/")
	public String test(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
			
//		session.setAttribute("username", "admin");	
//		
//		session.setAttribute("session_id", session.getId());	
//		
//		logger.info(session.getAttribute("username").toString());
//		
		logger.info(session.getId());
		
		
		redisTemplate.persist("persistance");
		
		
		
//		MessageDTO message = new MessageDTO("OKKKK");
		
		return session.getId();
	}

	
}
