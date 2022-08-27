package com.redis.redis.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisRepository {
	
	private String key = "USER";
	private RedisTemplate<String, Object> redis;
	private HashOperations hash;
	
	
	
	
	public RedisRepository() {
	
	}

	@Autowired
	public RedisRepository(RedisTemplate<String, Object> redis, HashOperations hash) {
		this.redis = redis;
		this.hash = hash;
	}
	

	
	
	
	
}
