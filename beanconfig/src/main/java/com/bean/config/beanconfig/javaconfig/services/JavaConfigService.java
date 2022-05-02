package com.bean.config.beanconfig.javaconfig.services;

public class JavaConfigService {
	
	
	private final String specialMessage;
	
	private final Integer specialNumber;
	
	
	
	
	public JavaConfigService(String specialMessage, Integer specialNumber) {
		this.specialMessage = specialMessage;
		this.specialNumber = specialNumber;
	}


	

	public String helloMessage() {
		return specialMessage+ " Your mark is " + specialNumber.toString();
	}
	

}
