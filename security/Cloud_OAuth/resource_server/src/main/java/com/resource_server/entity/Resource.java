package com.resource_server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resources")
public class Resource {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "resource_message")
	private String resourceMessage;

	public Resource() {
	}

	public Resource(String resourceMessage) {
		this.resourceMessage = resourceMessage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResourceMessage() {
		return resourceMessage;
	}

	public void setResourceMessage(String resourceMessage) {
		this.resourceMessage = resourceMessage;
	}
	
	
	
	
	
}
