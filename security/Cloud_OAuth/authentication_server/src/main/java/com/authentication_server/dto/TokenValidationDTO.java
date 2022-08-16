package com.authentication_server.dto;

public class TokenValidationDTO {
	
	
	private String username;
	private String token;
	
	
	public TokenValidationDTO() {
		// TODO Auto-generated constructor stub
	}
	public TokenValidationDTO(String username, String token) {
		this.username = username;
		this.token = token;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	

}
