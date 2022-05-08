package com.beanscope.beanscope;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.beanscope.beanscope.runner.Service1;
import com.beanscope.beanscope.runner.Service2;



@SpringBootApplication
public class BeanscopeApplication implements CommandLineRunner{

	@Autowired
	Service1 service1;
	
	@Autowired
	Service2 service2;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BeanscopeApplication.class, args);
		
	}

	@Override
	public void run(String... args) {
		stop();
	}
	
	

	private void stop() {
		throw new RuntimeException("Stop the service!");
	}
	



	
	
	
	
	
}
