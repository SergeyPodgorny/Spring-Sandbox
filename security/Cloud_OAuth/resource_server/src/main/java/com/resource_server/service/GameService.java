package com.resource_server.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.resource_server.dto.GameResponseDTO;
import com.resource_server.repository.GameRepository;

@Service
public class GameService {
	
	private GameRepository gameRepository;
	
	public List<GameResponseDTO> findAll() {
		return gameRepository.findAll().stream().map(GameResponseDTO::new).collect(Collectors.toList());
	}
	
	

}
