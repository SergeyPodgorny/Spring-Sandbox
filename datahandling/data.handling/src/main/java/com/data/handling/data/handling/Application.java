package com.data.handling.data.handling;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.data.handling.data.handling.entity.Account;
import com.data.handling.data.handling.repository.AccountRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	private AccountRepository accountRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		int i = 0;
		
		while(i<10) {
			
			accountRepository.save(new Account("Stinson", "Stinson@SuperStar.com", 2));
			
			i++;
		
		}
		
		
		System.out.println(accountRepository.getAcc(2L));
		
		
//		jdbcTemplate.execute("INSERT INTO ACCOUNT (id, name, email, age) VALUES (1, 'Stinson', 'asdasdgmailcom', 15)");
		
		
//		System.out.println(getAccountById(1L));
		
		
//		Map<String, Object> queryResult = jdbcTemplate.queryForMap("SELECT * FROM ACCOUNT");
//		
//		System.out.println(queryResult.get("age"));
		
		
	}
	
	
	private Account getAccountById(Long id) {
		
		String query = "SELECT * FROM Account WHERE id=%s";
		
		Map<String, Object> queryResult = jdbcTemplate.queryForMap(String.format(query, id));
		
		Account account = new Account();
		
		account.setAge((Integer) queryResult.get("age"));
		
		account.setEmail((String) queryResult.get("email"));
		
		account.setName((String) queryResult.get("name"));
		
		return account;
		
	}
	
	

}
