package com.resource_server.controller;



import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.resource_server.ResourceApplication;
import com.resource_server.dto.GameResponseDTO;
import com.resource_server.service.GameService;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8090"})
public class GameController {

	private final Logger logger = LoggerFactory.getLogger(ResourceApplication.class);
	
	private GameService gameService;


	@Autowired
	public GameController(GameService gameService) {
		this.gameService = gameService;
	}



	@GetMapping("/getAll")
	public ResponseEntity<List<GameResponseDTO>> getAllGames(@RequestHeader Map<String, String> headers){
		
		headers.forEach((key, value) -> {
			logger.info(String.format("Header '%s' = %s", key, value));
	    });
		
		return ResponseEntity.ok(gameService.findAll());
		
		
	}


	
	
	
}
