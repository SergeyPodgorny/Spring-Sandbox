package com.resource_server.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resource_server.ResourceApplication;
import com.resource_server.dto.GameResponseDTO;
import com.resource_server.service.GameService;

@RestController
@CrossOrigin
public class GameController {

	private final Logger logger = LoggerFactory.getLogger(ResourceApplication.class);
	
	private GameService gameService;


	@Autowired
	public GameController(GameService gameService) {
		this.gameService = gameService;
	}



	@GetMapping("/getAll")
	public List<GameResponseDTO> getAllGames(){
		return gameService.findAll();
		
		
	}


	@GetMapping("/test")
	public String youShouldNotSeeThisMessage() {
		return "If you see this message close the browser!";
	}
	
	
	
	
	
	
	
}
