package com.aaslin.DispatcherServlet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DispatcherController {

    @GetMapping("/hello")
    public String hello(Model model) {
        System.out.println(" Controller: Inside hello() method");
        model.addAttribute("message", "Hello from Controller");
        return "hello";
    }

    @GetMapping("/api/greet")
    @ResponseBody
    public String greet() {
        System.out.println(" Controller: Inside greet() method");
        return "Hello from REST endpoint";
    }
}

