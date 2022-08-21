package com.authentication_server.dto;

public class TokenValidationRequestDTO {
	
	
	
	private String token;
	
	
	public TokenValidationRequestDTO() {
	
	}

	public TokenValidationRequestDTO(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


}
