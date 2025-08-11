package com.aaslin.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

	@GetMapping("/print")
	public String greet(Model model) {
		model.addAttribute("message","greeetings from thymeleaf..");
		return "greeting";
	}
}
