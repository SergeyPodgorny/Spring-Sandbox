package com.redis.redis;

import java.io.Serializable;

public class MessageDTO implements Serializable{
	
	
	private String message;

	public MessageDTO() {
		// TODO Auto-generated constructor stub
	}

	public MessageDTO(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	

}
