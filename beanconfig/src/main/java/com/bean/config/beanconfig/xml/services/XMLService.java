package com.bean.config.beanconfig.xml.services;

public class XMLService {
	
	
	private AnotherService anotherService;
	
	private OneMoreService oneMoreService;
	
	
	public String printMessage() {
		return anotherService.append("Hello XML!");
	}

	
	public int printAnotherMessage() {
		return oneMoreService.showNumber();
	}
	
	
	public void setOneMoreService(OneMoreService oneMoreService) {
		this.oneMoreService = oneMoreService;
	}


	public void setAnotherService(AnotherService anotherService) {
		this.anotherService = anotherService;
	}
	
	

}
