package com.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaProducerApplication implements CommandLineRunner{

	
	private final Logger log = LoggerFactory.getLogger(KafkaProducerApplication.class);
	
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		sendMessage("test","DDDDDDDDDDDDDDDD!!!!!!!!!!");
		
		
	}
	
	
	private void sendMessage(String topicName, String message) {
		kafkaTemplate.send(topicName, message);
	}
	
	

}
