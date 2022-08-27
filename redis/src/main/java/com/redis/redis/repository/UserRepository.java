package com.redis.redis.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.redis.redis.entity.User;

@Repository
public class UserRepository {
	
	private String KEY = "USER";
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	private HashOperations hashOperations;
	
	
	
	
	public UserRepository() {
	
	}

	@Autowired
	public UserRepository(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
		hashOperations = redisTemplate.opsForHash();
	}
	

	
	
	
	
	  //Get all by key
    public Map<String,User> getAllItems(){
        return  hashOperations.entries(KEY);
    }
	
	// Create entry
    public void addItem(User user){
        hashOperations.put(KEY,user.getId(),user);
    }
    
    // Get entry
    public User getItem(String id){
        return (User) hashOperations.get(KEY,id);
    }
    
	
    //delete entry
    public void deleteItem(String id) {
    	hashOperations.delete(KEY, id);
    }
    
    //update entry
    public void updateItem(User user){
        addItem(user);
    }
}
