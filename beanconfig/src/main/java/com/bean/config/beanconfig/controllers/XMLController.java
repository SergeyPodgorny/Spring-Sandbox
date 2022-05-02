package com.bean.config.beanconfig.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.config.beanconfig.services.XMLService;




@RestController
public class XMLController {

	
	
	private final XMLService xmlService;
	
	
	@Autowired
	public XMLController(XMLService xmlService) {
		this.xmlService = xmlService;
	}


	@GetMapping("/helloXML")
	public String helloXML() {
		return xmlService.printMessage();
	}
	
	@GetMapping("/helloXML2")
	public int helloXML2() {
		return xmlService.printAnotherMessage();
	}
	
	
}
