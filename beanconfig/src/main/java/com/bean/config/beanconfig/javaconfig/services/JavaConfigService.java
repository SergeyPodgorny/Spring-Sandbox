package com.bean.config.beanconfig.javaconfig.services;

public class JavaConfigService {
	
	
	private String specialMessage;
	
	private Integer specialNumber;
	
	
	
	
	public JavaConfigService(String specialMessage, Integer specialNumber) {
		this.specialMessage = specialMessage;
		this.specialNumber = specialNumber;
	}


	

	public JavaConfigService() {
		setSpecialMessage("Hello from lame java config");
		setSpecialNumber(5);
		
	}

	public String helloMessage() {
		return specialMessage+ " Your mark is " + specialNumber.toString();
	}




	public String getSpecialMessage() {
		return specialMessage;
	}




	public void setSpecialMessage(String specialMessage) {
		this.specialMessage = specialMessage;
	}




	public Integer getSpecialNumber() {
		return specialNumber;
	}




	public void setSpecialNumber(Integer specialNumber) {
		this.specialNumber = specialNumber;
	}
	
	
	
	

}
