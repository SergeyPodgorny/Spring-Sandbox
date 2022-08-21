package com.authentication_server.dto;

public class TokenValidationResponseDTO {
	
	
	private Boolean isTokenValid;

	public TokenValidationResponseDTO() {
		
	}

	public TokenValidationResponseDTO(Boolean isTokenValid) {
		this.isTokenValid = isTokenValid;
	}

	public Boolean getIsTokenValid() {
		return isTokenValid;
	}

	public void setIsTokenValid(Boolean isTokenValid) {
		this.isTokenValid = isTokenValid;
	}
	
	
	
	
	

}
