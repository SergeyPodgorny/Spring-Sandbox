package com.bean.config.beanconfig.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bean.config.beanconfig.javaconfig.services.JavaConfigService;

@Configuration
public class JavaConfiguration {

	
	@Bean(name = "full auto config")
	public JavaConfigService javaConfigService() {
		
		
		JavaConfigService javaConfigService = new JavaConfigService("Hello from preadjusted Java Configured Bean!", 5);
		
		
		return javaConfigService;
	}
	
	
	@Bean(name = "lame config")
	public JavaConfigService javaConfigService1() {
	
	
	JavaConfigService javaConfigService = new JavaConfigService();
	
	
	return javaConfigService;
	
	}
	
}
