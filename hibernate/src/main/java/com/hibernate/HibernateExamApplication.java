package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.hibernate.configuration.entity.Account;
import com.hibernate.configuration.entity.AccountDAO;
import com.hibernate.configuration.entity.Bill;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class})
public class HibernateExamApplication implements CommandLineRunner {

	@Autowired
	private AccountDAO accountDAO;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateExamApplication.class, args);
	}

	
	
	@Override
	public void run(String... args) {
		
		
		Account account = new Account("Stinson",2);
		
		List<Bill> bills = new ArrayList<>();
		
		
		for (int i = 0; i<10; i++) {
			bills.add(new Bill((long) (1+i)));
		}
		
		account.setBill(bills);
		
		
		Account accountDB = accountDAO.save(account);
		System.out.println(accountDAO.findById(1L).toString());
		
		System.out.println(accountDB.getBill());
		
		accountDB.getBill().stream().forEach(System.out::println);
		
	}
	
	
	
}
