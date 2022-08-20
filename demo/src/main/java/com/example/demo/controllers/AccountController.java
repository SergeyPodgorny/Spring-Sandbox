package com.example.demo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controllers.dto.AccountRequestDTO;
import com.example.demo.controllers.dto.AccountResponseDTO;
import com.example.demo.service.AccountService;

@RestController
@CrossOrigin
public class AccountController {
	
	private final AccountService accountService;
	
	
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}


	@GetMapping("/hello")
	public String helloController() {
		return "Hello";
	}
	
	@PostMapping("/accounts") 
	public Long createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
		return accountService.createAccount(accountRequestDTO.getName(), accountRequestDTO.getEmail(), accountRequestDTO.getBill());
	}
	
	@GetMapping("/accounts/{id}")
	public AccountResponseDTO getAccount(@PathVariable Long id) {
		return new AccountResponseDTO(accountService.getAccountById(id));
		
	
//	@GetMapping("/accounts")
//	public List<AccountResponseDTO> getAl() {
//		return accountService.getAll().stream().map(AccountResponseDTO::new).collect(Collectors.toList());
//	}
		
	}
	
}
