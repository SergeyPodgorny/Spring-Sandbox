package com.resource_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resource_server.entity.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
	
	
}
