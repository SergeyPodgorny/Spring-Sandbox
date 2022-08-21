package com.authentication_server.dto;


public class TokenResponseDTO {
	
	
	private String token;

	public TokenResponseDTO() {

	}

	public TokenResponseDTO(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "TokenResponseDTO [token=" + token + "]";
	}
	
	
	
	

}
