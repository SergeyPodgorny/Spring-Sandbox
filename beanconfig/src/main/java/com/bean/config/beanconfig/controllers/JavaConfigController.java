package com.bean.config.beanconfig.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.config.beanconfig.javaconfig.services.JavaConfigService;

@RestController
public class JavaConfigController {
	
	
	JavaConfigService javaConfigService;
	
	@Autowired
	public JavaConfigController(JavaConfigService javaConfigService) {
		this.javaConfigService = javaConfigService;
	}
	
	@GetMapping("helloJava")
	public String messagePrinter() {
		return javaConfigService.helloMessage();
	}
	
	

}
