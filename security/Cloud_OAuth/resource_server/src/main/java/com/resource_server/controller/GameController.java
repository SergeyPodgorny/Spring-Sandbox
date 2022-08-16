package com.resource_server.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.resource_server.dto.GameRequestDTO;
import com.resource_server.dto.GameResponseDTO;
import com.resource_server.service.GameService;

@RestController
public class GameController {

	
	private GameService gameService;
	
	private RestTemplate restTemplate;
	
	
	@Autowired	
	public GameController(GameService gameService, RestTemplate restTemplate) {
		this.gameService = gameService;
		this.restTemplate = restTemplate;
	}




	@GetMapping("/rest")
	public String getAllGames(){
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>(headers);	
		
		return restTemplate.exchange("http://localhost:8090/games/getAll", HttpMethod.GET, entity, String.class).getBody();
	}



	
	
	
	
	
	
	
}
