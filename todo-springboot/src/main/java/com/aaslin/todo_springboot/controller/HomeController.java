package com.aaslin.todo_springboot.controller;

import com.aaslin.todo_springboot.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final TodoService todoService;

    public HomeController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        return "index"; // maps to templates/index.html
    }
}
