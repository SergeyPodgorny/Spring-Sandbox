package com.example.demo.controllers.dto;

import com.example.demo.entity.Account;

public class AccountResponseDTO {
	
	
	private String name;
	private String email;
	private Integer bill;
	private Long accountId;
	
	public AccountResponseDTO(String name, String email, Integer bill, Long accountId) {
		this.name = name;
		this.email = email;
		this.bill = bill;
		this.accountId = accountId;
	}

	public AccountResponseDTO(Account account) {
		name = account.getName();
		email = account.getEmail();
		bill = account.getBill();
		accountId = account.getId();
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getBill() {
		return bill;
	}

	public void setBill(Integer bill) {
		this.bill = bill;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	
	
	

}
