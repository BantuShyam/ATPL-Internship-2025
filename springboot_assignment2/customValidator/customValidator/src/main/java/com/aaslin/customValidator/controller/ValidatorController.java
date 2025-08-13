package com.aaslin.customValidator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaslin.customValidator.dto.UserRegistration;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/register")
public class ValidatorController {
	
	@PostMapping
	public ResponseEntity<String> registerUser(@Valid @RequestBody UserRegistration user){
		return ResponseEntity.ok("User registered successfully: "+user.getUserName());
	}
}
