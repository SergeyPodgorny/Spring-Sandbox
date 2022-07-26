package com.caching.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import com.caching.entity.Game;
import com.caching.repository.GameRepositoryImpl;
@Component
@CacheConfig(cacheNames = "games")
public class GameService {

	
	private GameRepositoryImpl gameRepositoryImpl;
	
	@Autowired	
	public GameService(GameRepositoryImpl gameRepositoryImpl) {
		this.gameRepositoryImpl = gameRepositoryImpl;
	}

	@Cacheable
	public Game findGameById(String id) {
		return gameRepositoryImpl.findGameById(id);
	}
	
	
	
}
