package com.data.handling.data.handling.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.data.handling.data.handling.entity.Account;


@Repository
public interface AccountRepository extends JpaRepository <Account,Long> {
	
	@Query(nativeQuery = true, value = "SELECT id, age FROM Account WHERE id= :accountId")
	public Long getAcc(@Param("accountId") Long id);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE Account SET Account.name =?1 WHERE Account.id = ?2")
	public void updateName(String name, Long id);
	
	
	public Account getAccountById(Long id);
	
}
