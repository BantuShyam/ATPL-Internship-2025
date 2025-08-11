package com.aaslin.Beans.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaslin.Beans.service.GreetingService;

@RestController
public class GreetingController {
	private final GreetingService greetingService;

	public GreetingController(GreetingService greetingService) {
		super();
		this.greetingService = greetingService;
	}
	
	@GetMapping("/greet")
	public String greeting() {
		 return greetingService.greet();
	}

}
