package com.store.StockManagementSystem.controller;

import com.store.StockManagementSystem.model.User;
import com.store.StockManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller // Changed to @Controller for Thymeleaf views
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup"; // Show signup page (Thymeleaf view)
    }

    @PostMapping("/signup")
    public String registerUser(@ModelAttribute User user) {
        // Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return "redirect:/login?success"; // Redirect to login page after successful signup
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Show login page (Thymeleaf view)
    }

    // If you want to keep the API approach for REST endpoints:
    @PostMapping("/api/login")
    public ResponseEntity<String> loginUser(@RequestParam String username, @RequestParam String password) {
        // Spring Security will automatically authenticate user for you
        return ResponseEntity.ok("Login successful"); // Placeholder
    }
}
