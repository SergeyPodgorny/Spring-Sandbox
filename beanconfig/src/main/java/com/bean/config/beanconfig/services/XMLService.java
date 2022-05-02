package com.bean.config.beanconfig.services;

public class XMLService {
	
	
	private AnotherService anotherService;
	
	
	
	
	public String printMessage() {
		return anotherService.append("Hello XML!");
	}


	public void setAnotherService(AnotherService anotherService) {
		this.anotherService = anotherService;
	}
	
	

}
