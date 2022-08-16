package com.resource_server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.resource_server.dto.GameRequestDTO;
import com.resource_server.dto.GameResponseDTO;


@SpringBootApplication
public class ResourceApplication implements CommandLineRunner {

	
	@Autowired
	private RestTemplate restTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(ResourceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	}




}
