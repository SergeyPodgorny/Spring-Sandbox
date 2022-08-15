package com.resource_server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resource_server.dto.GameResponseDTO;
import com.resource_server.service.GameService;

@RestController
public class GameController {

	
	private GameService gameService;
	
	
	
	@Autowired	
	public GameController(GameService gameService) {
		this.gameService = gameService;
	}




	@GetMapping("/getAll")
	public List<GameResponseDTO> getAllGames(){
		return gameService.findAll();
	}
	
	
	
	
}
