package com.beanscope.beanscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.beanscope.beanscope.service.ServicePrototype;
import com.beanscope.beanscope.service.ServiceSingleton;

@SpringBootApplication
public class BeanscopeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeanscopeApplication.class, args);
	}

	
	@Autowired
	private ServicePrototype servicePrototype;
	
	@Autowired
	private ServiceSingleton serviceSingleton;
	



	
	
	
	
	
}
