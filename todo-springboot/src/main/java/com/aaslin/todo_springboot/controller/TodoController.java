package com.aaslin.todo_springboot.controller;

import com.aaslin.todo_springboot.model.Todo;
import com.aaslin.todo_springboot.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // Show Add Todo form
    @GetMapping("/add")
    public String addTodoForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "add-todo";   // templates/add-todo.html
    }

    // Handle form submission
    @PostMapping("/add")
    public String addTodo(@ModelAttribute Todo todo) {
        todoService.addTodo(todo);
        return "redirect:/"; 
    }

    @GetMapping
    public String viewTodos(Model model) {
        List<Todo> todos = todoService.getAllTodos();
        model.addAttribute("todos", todos);
        return "index";   // templates/index.html
    }

    // Update status
    @GetMapping("/updateStatus/{id}")
    public String updateStatus(@PathVariable Long id, @RequestParam String status) {
        todoService.updateStatus(id, status);
        return "redirect:/";
    }

    // Report page
    @GetMapping("/report")
    public String reportPage(@RequestParam(required = false) String start,
                             @RequestParam(required = false) String end,
                             Model model) {
        List<Todo> todos = todoService.getAllTodos();
        model.addAttribute("todos", todos);
        return "report";  // templates/report.html
    }
 // Show Weekly Todos
    @GetMapping("/weekly")
    public String viewWeeklyTodos(Model model) {
        model.addAttribute("todos", todoService.getWeeklyTodos());
        model.addAttribute("viewType", "Weekly Tasks");
        return "index"; // reuse dashboard
    }

    // Show Monthly Todos
    @GetMapping("/monthly")
    public String viewMonthlyTodos(Model model) {
        model.addAttribute("todos", todoService.getMonthlyTodos());
        model.addAttribute("viewType", "Monthly Tasks");
        return "index"; // reuse dashboard
    }

}
