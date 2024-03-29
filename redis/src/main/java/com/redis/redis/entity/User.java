package com.redis.redis.entity;

import java.io.Serializable;

public class User implements Serializable{
	
	private String name;
	
	private String id;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + "]";
	}
	
	
	

}
