package com.beanscope.beanscope.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class ServicePrototype {
	
	
	private String state = "state1";

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@PostConstruct
	public void init() {
		System.out.println();
		System.out.println("Service Prototype runned");
		System.out.println();
	}
	
	
	@PreDestroy
	public void ending() {
		System.out.println();
		System.out.println("Service Prototype deleted from context");
		System.out.println();
	}
	

}
