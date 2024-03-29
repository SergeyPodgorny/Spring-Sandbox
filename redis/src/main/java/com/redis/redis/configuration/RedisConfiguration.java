package com.redis.redis.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;




@Configuration
public class RedisConfiguration {

	

	
	
//	@Bean
//	public LettuceConnectionFactory lettuceConnectionFactory() {
//		  return new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost", 6379));
//	 }
	
	
	 @Bean
	 public JedisConnectionFactory jedisConnectionFactory() {
		 RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("localhost", 6379);
		 return new JedisConnectionFactory(config);
	 }
	
	
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
//		template.setConnectionFactory(lettuceConnectionFactory());
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}
	

	
	
}
