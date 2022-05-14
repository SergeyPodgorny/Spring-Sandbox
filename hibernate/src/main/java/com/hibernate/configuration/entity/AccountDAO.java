package com.hibernate.configuration.entity;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	
	private final SessionFactory sessionFactory;
	
	
	@Autowired
	public AccountDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public void save(Account account) {
		Session session = sessionFactory.openSession();		
		session.beginTransaction();
		session.save(account);
		session.flush();
		session.getTransaction().commit();
		session.close();
		System.out.println("account: "+ account.toString() + " saved");
	}
	
	public Account findById(Long id) {
		Session session = sessionFactory.openSession();
		Account account = session.find(Account.class,id);
		session.close();
		return account;	
	}
	
}
