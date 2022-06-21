package com.beanscope.beanscope.runner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.beanscope.beanscope.service.ServicePrototype;
import com.beanscope.beanscope.service.ServiceSingleton;

@Service
public class Service1 implements CommandLineRunner {

	
	@Autowired
	private ServicePrototype servicePrototype;
	
	@Autowired
	private ServiceSingleton serviceSingleton;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		
		System.out.println("Service1");
		
		System.out.println();
		
		System.out.println("Prototype");
		
		servicePrototype.setState("state2");
		
		System.out.println(servicePrototype.getState());
		
		
		System.out.println("Singleton");
		
		serviceSingleton.setState("state2");
		
		System.out.println(serviceSingleton.getState());
		
		System.out.println();
	}
	
}
