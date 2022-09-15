package com.redis.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.redis.redis.configuration.RedisConfiguration.*;

@SpringBootApplication
public class RedisApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
		
		System.out.println(1+'0');
		
		
	}
	
	
//	public static  <T>  T method (T t){
//		return t;
//	}
	

}
