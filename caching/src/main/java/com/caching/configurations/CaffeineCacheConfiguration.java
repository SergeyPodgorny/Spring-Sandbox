package com.caching.configurations;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;


@Configuration
public class CaffeineCacheConfiguration {

	
	@Bean
	public CacheManager cacheManager() {
		CaffeineCacheManager cacheManager = new CaffeineCacheManager("games");
		cacheManager.setCaffeine(caffeineCache());
		return cacheManager;
	}
	
	
	
	public Caffeine<Object,Object> caffeineCache(){
		return Caffeine.newBuilder().initialCapacity(1).maximumSize(10).expireAfterAccess(1, TimeUnit.SECONDS);
	}
	

	
}
