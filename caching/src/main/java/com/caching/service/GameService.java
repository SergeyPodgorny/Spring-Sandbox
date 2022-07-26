package com.caching.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.caching.entity.Game;
import com.caching.repository.GameRepositoryImpl;
@Component
public class GameService {

	
	private GameRepositoryImpl gameRepositoryImpl;
	
	@Autowired	
	public GameService(GameRepositoryImpl gameRepositoryImpl) {
		this.gameRepositoryImpl = gameRepositoryImpl;
	}


	public Game findGameById(String id) {
		return gameRepositoryImpl.findGameById(id);
	}
	
	
	
}
