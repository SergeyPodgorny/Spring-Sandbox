package com.resource_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resource_server.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
	
	
	
}
