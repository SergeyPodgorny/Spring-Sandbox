package com.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class KafkaListenerApplication {

	
	private Logger log = LoggerFactory.getLogger(KafkaListenerApplication.class);
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaListenerApplication.class, args);
	}

	@KafkaListener(topics = "test", groupId = "group-id")
	public void listen(String message) {
		log.info("Recieved message contains: " + message);
	}
	
	
	
	
}
