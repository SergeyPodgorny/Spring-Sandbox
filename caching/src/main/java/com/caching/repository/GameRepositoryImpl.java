package com.caching.repository;

import org.springframework.stereotype.Component;

import com.caching.entity.Game;
@Component
public class GameRepositoryImpl implements GameRepository{
	
	
	@Override
	public Game findGameById(String id) {
		loadImmitation();
		return new Game("Doom eternal");
	}

	private void loadImmitation() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
