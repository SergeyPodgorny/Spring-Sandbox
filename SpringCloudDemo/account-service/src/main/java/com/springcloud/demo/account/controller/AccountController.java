package com.springcloud.demo.account.controller;


import com.springcloud.demo.account.dto.AccountDTO;
import com.springcloud.demo.account.entity.Account;
import com.springcloud.demo.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
public class AccountController {


    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    /** crud http methods for Account entity
     *
     */

    @GetMapping("/{id}")
    public AccountDTO getAccountById(@PathVariable Long id){
        return new AccountDTO(accountService.getAccountById(id));
    }

    @PostMapping("/create")
    public void createAccount(@RequestBody AccountDTO accountDTO){
        Account creatingAccount = new Account(accountDTO.getName(), accountDTO.getEmail(),
                accountDTO.getPhone(),accountDTO.getBills(), OffsetDateTime.now());
        accountService.createAccount(creatingAccount);
    }
    @DeleteMapping("/{id}")
    public void deleteAccountById(@PathVariable Long id) {
        accountService.deleteAccount(id);

    }

    @PutMapping("/{id}")
    public void updateAccount(@PathVariable Long id, @RequestBody AccountDTO accountDTO){
        accountService.updateAccount(id,accountDTO);


    }




}
