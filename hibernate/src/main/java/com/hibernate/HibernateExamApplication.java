package com.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.hibernate.configuration.entity.Account;
import com.hibernate.configuration.entity.AccountDAO;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class})
public class HibernateExamApplication implements CommandLineRunner {

	@Autowired
	private AccountDAO accountDAO;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateExamApplication.class, args);
	}

	
	
	@Override
	public void run(String... args) {
		accountDAO.save(new Account("Stinson",2));
		System.out.println(accountDAO.findById(1L).toString());
		
	}
	
	
	
}
