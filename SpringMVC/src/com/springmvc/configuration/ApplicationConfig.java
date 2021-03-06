package com.springmvc.configuration;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableWebMvc
@ComponentScan("com.springmvc")
public class ApplicationConfig extends WebMvcConfigurerAdapter{

	
	public void cofigureMessageConverters(List<HttpMessageConverter<?>> converters) {
		
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(new ObjectMapper());
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
		converters.add(converter);
		
	}
	
	
	
}
