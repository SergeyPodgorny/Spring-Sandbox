package com.resource_server.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.resource_server.ResourceApplication;
import com.resource_server.dto.GameRequestDTO;
import com.resource_server.dto.GameResponseDTO;
import com.resource_server.jwt_utils.JwtFilter;
import com.resource_server.service.GameService;

@RestController
public class GameController {

	private final Logger logger = LoggerFactory.getLogger(ResourceApplication.class);
	
	private GameService gameService;
	
	private RestTemplate restTemplate;
	
	private JwtFilter jwtFilter;
	


	


	@Autowired
	public GameController(GameService gameService, RestTemplate restTemplate, JwtFilter jwtFilter) {
		this.gameService = gameService;
		this.restTemplate = restTemplate;
		this.jwtFilter = jwtFilter;
	}



	@GetMapping("/rest")
	public List<GameResponseDTO> getAllGames(){
		return gameService.findAll();
		
		
	}



	
	
	
	
	
	
	
}
