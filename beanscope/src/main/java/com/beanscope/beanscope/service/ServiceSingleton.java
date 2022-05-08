package com.beanscope.beanscope.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiceSingleton {

	
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
		System.out.println("Service Singleton runned");
		System.out.println();
	}
	
	
	@PreDestroy
	public void ending() {
		System.out.println();
		System.out.println("Service Singleton deleted from context");
		System.out.println();
	}
	
}
