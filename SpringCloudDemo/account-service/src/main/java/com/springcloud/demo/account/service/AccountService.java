package com.springcloud.demo.account.service;



import com.springcloud.demo.account.dto.AccountDTO;
import com.springcloud.demo.account.entity.Account;
import com.springcloud.demo.account.exceptions.AccountNotFoundException;
import com.springcloud.demo.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {


    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * crud methods for account entity
     *
     */
       public Account getAccountById(Long accountId){
        return accountRepository.findById(accountId)
                .orElseThrow(()-> new AccountNotFoundException("Account with accountId: " + accountId + " not found"));
    }

    public void createAccount(Account account) {
        accountRepository.save(account);
    }

    public void deleteAccount(Long accountId) {
        Account accountToBeDeleted = getAccountById(accountId);
        accountRepository.delete(accountToBeDeleted);
    }

    public void updateAccount(Long accountId, AccountDTO accountDTO){
           Account updatingAccount = new Account();
           updatingAccount.setId(accountId);
           updatingAccount.setName(accountDTO.getName());
           updatingAccount.setBills(accountDTO.getBills());
           updatingAccount.setEmail(accountDTO.getEmail());
           updatingAccount.setPhone(accountDTO.getPhone());
           accountRepository.save(updatingAccount);

    }








}
