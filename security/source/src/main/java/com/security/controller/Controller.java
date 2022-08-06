package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	
	@GetMapping("/start_page")
	public String startPage() {
		return "everything works!";
	}
	

}
