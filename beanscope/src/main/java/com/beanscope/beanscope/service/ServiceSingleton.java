package com.beanscope.beanscope.service;

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
	
	
	
}
