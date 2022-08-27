package com.redis.redis.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.redis.RedisApplication;
import com.redis.redis.entity.NotSoSuperUser;
import com.redis.redis.entity.SuperUser;
import com.redis.redis.entity.User;
import com.redis.redis.repository.NotSoRepository;
import com.redis.redis.repository.UserRepository;

@RestController
public class Controller {

	
	@Autowired
	private UserRepository redisRepository;
	
	@Autowired
	NotSoRepository notSoRepository;
	
	private final Logger logger = LoggerFactory.getLogger(RedisApplication.class);
	
	
	
	@PostConstruct
	public void init() {
		
		User user = new User("1", "Sonya");
		
		User user1 = new User("2", "Stinson"); 
		
		SuperUser user3 = new SuperUser("3", "SuperSonya");
		
		SuperUser user4 = new SuperUser("4", "SuperStinson"); 
		
		NotSoSuperUser user5 = new NotSoSuperUser("5", "NoSoSonya");
		
		NotSoSuperUser user6 = new NotSoSuperUser("6", "NoSoStinson");
		
		redisRepository.addItem(user);
		
		redisRepository.addItem(user1);
		
		redisRepository.addItem(user3);
		
		redisRepository.addItem(user4);
		
		notSoRepository.addItem(user5);
		
		notSoRepository.addItem(user6);
		
		logger.info(redisRepository.getAllItems().toString());
		
		redisRepository.deleteItem("5");
		
		logger.info(redisRepository.getAllItems().toString());
		
//		logger.info(notSoRepository.getAllItems().toString());
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
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
		
		
//		MessageDTO message = new MessageDTO("OKKKK");
		
		return session.getId();
	}

	
}
