package com.resource_server.configuration;

import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MiscellaneousConfiguration {

	
	@Bean
	public JSONObject jsonObject() {
		return new JSONObject();
	}
	
	
	@Bean
	public HttpHeaders headers() {
		return new HttpHeaders();
	}
	
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
