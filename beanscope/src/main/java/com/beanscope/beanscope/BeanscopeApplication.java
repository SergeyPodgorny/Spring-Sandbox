package com.beanscope.beanscope;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.beanscope.beanscope.runner.Service1;
import com.beanscope.beanscope.runner.Service2;
import com.beanscope.beanscope.service.ServicePrototype;
import com.beanscope.beanscope.service.ServiceSingleton;



@SpringBootApplication
public class BeanscopeApplication implements CommandLineRunner{

	
	
	@Autowired
	ApplicationContext applicationContext;
	
	
	@Autowired
	Service1 service1;
	
	@Autowired
	Service2 service2;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BeanscopeApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		ServicePrototype servicePrototype = (ServicePrototype) applicationContext.getBean("servicePrototype");
		
		applicationContext.getAutowireCapableBeanFactory().destroyBean(servicePrototype);
		
		ServiceSingleton serviceSingleton = (ServiceSingleton) applicationContext.getBean("serviceSingleton");
		
		applicationContext.getAutowireCapableBeanFactory().destroyBean(serviceSingleton);
		
		
	}
	
	
	
	
	

	private void stop() {
		throw new RuntimeException("Stop the service!");
	}
	



	
	
	
	
	
}
