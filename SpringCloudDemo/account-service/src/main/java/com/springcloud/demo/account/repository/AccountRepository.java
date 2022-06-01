package com.springcloud.demo.account.repository;

import com.springcloud.demo.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {



}
