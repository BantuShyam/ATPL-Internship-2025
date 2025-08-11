package com.aaslin.user.controller;

import org.springframework.web.bind.annotation.*;

import com.aaslin.user.model.User;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/users")
public class UserController {

    private Map<Integer, User> userDatabase = new HashMap<>();

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userDatabase.getOrDefault(id, new User(0, "User not found","n/a"));
    }

    @PostMapping
    public String addUser(@RequestBody User user) {
        userDatabase.put(user.getId(), user);
        return "User added successfully!";
    }
}