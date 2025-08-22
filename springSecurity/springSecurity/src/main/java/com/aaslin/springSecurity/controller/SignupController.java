package com.aaslin.springSecurity.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.aaslin.springSecurity.model.AppUser;
import com.aaslin.springSecurity.repository.AppUserRepository;

@RestController
@RequestMapping("/auth")
public class SignupController {

    private final AppUserRepository repo;
    private final PasswordEncoder encoder;

    public SignupController(AppUserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @PostMapping("/signup")
    public String signup(@RequestBody AppUser user) {
        user.setPassword(encoder.encode(user.getPassword()));
        if (!user.getRole().startsWith("ROLE_")) {
            user.setRole("ROLE_" + user.getRole().toUpperCase());
        }
        repo.save(user);
        return "User registered!";
    }
}
