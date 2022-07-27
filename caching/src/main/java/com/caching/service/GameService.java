package com.caching.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.caching.CachingApplication;
import com.caching.entity.Game;
import com.caching.repository.GameRepository;
import com.caching.repository.GameRepositoryImpl;

@Component
@CacheConfig(cacheNames = "games")
public class GameService {

	
	
	private static final Logger logger = LoggerFactory.getLogger(CachingApplication.class);
	
	private GameRepositoryImpl gameRepositoryImpl;
	
	@Autowired	
	public GameService(GameRepositoryImpl gameRepositoryImpl) {
		this.gameRepositoryImpl = gameRepositoryImpl;
	}

	@Cacheable
	public Game findGameById(String id) {
		
		logger.info("service started");
		Game foundEntry = gameRepositoryImpl.findGameById(id); 
		
		return foundEntry;
		
		
	}
	
	
	
}
