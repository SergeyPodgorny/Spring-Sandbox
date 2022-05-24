package com.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

		
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}
	
	
	@RequestMapping(value = "/hello2", method = RequestMethod.POST)
	public String hello2() {
		return "hello";
	}
	
	
	
	
	
	
	
}
