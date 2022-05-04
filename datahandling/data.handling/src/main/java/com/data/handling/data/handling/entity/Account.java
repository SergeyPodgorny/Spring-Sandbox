package com.data.handling.data.handling.entity;

import javax.persistence.Entity;

@Entity
public class Account {

	
	private Long id;
	
	private String name;
	
	private String email;
	
	private Integer age;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(Long id, String name, String email, Integer age) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
	
	
}
