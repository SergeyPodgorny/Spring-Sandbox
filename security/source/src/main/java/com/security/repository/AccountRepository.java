package com.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.security.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	public Optional<Account> findUserByUsername(String username);

}
