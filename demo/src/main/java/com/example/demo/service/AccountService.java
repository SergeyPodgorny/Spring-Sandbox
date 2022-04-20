package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.exceptions.AccountNotFoundException;
import com.example.demo.repository.AccountRepository;

@Service
public class AccountService {
	
	private final AccountRepository accountRepository;
	
	@Autowired
	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public Long createAccount(String name, String email, Integer bill) {
		Account account = new Account(name, email, bill);
		return accountRepository.save(account).getId();
	}
	
	public Account getAccountById(Long id) {
		return accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Cannot find an account with id" +" "+ id));
	}
	
	public List<Account> getAll(){
		return accountRepository.findAll();
	}
	
}
