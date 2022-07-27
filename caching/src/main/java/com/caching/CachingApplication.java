package com.caching;

import java.time.Duration;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.caching.service.GameService;

@SpringBootApplication
@EnableCaching
public class CachingApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CachingApplication.class, args);
	}

	
	@Autowired
	private GameService gameService;
	
	private int n = 0;
	
	private static final Logger logger = LoggerFactory.getLogger(CachingApplication.class);


	public void run(String... args) {
	
		
		while(n < 3) {
			logger.info("service started");
			Instant startTme = Instant.now();
			System.out.println(gameService.findGameById(""));
			n++;
			Instant endTime = Instant.now();
			System.out.println("time spent to get the game from db: " + Duration.between(startTme, endTime).toMillis()+ " milliseconds");
			logger.info("service terminated");
			
		}

		logger.error("END");
	}
	
	
	
	
}
