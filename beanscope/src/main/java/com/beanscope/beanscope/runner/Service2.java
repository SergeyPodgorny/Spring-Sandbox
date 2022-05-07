package com.beanscope.beanscope.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.beanscope.beanscope.service.ServicePrototype;
import com.beanscope.beanscope.service.ServiceSingleton;

@Service
public class Service2 implements CommandLineRunner {

	
	
	@Autowired
	private ServicePrototype servicePrototype;
	
	@Autowired
	private ServiceSingleton serviceSingleton;
	
	
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Service2");
		
		System.out.println();
		
		System.out.println("Prototype");
		
		System.out.println(servicePrototype.getState());
		
		
		
		System.out.println("Singleton");
		
		System.out.println(serviceSingleton.getState());
		
		
		
	}
	

	
	
	
}
