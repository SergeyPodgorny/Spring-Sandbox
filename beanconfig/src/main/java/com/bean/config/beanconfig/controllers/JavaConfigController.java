package com.bean.config.beanconfig.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.config.beanconfig.javaconfig.services.JavaConfigService;

@RestController
public class JavaConfigController {
	
	
	JavaConfigService javaConfig;
	
	@Autowired
	public JavaConfigController(@Qualifier("lame config") JavaConfigService javaConfig) {
		this.javaConfig = javaConfig;
	}
	
	@GetMapping("/helloJava")
	public String messagePrinter() {
		return javaConfig.helloMessage();
	}
	
	

}
