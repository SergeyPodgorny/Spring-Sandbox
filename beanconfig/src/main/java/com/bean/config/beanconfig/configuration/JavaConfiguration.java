package com.bean.config.beanconfig.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bean.config.beanconfig.javaconfig.services.JavaConfigService;

@Configuration
public class JavaConfiguration {

	
	@Bean
	public JavaConfigService javaConfigService() {
		
		
		JavaConfigService javaConfigService = new JavaConfigService("Hello from preadjusted Java Configured Bean!", 5);
		
		
		return javaConfigService;
	}
	
	
}
