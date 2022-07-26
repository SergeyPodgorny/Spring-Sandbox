package com.caching.repository;

import com.caching.entity.Game;

public interface GameRepository {
	
	
	Game findGameById(String id);
	

}
