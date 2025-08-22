package com.aaslin.springSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello,  Shyam!";
    }

    @GetMapping("/")
    public String home() {
        return "Welcome! Please login at /hello";
    }
}

