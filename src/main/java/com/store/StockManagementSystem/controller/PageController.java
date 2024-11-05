package com.store.StockManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String login() {
        return "login"; // return the login.html template
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup"; // return the signup.html template
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/login"; // Redirect to login if accessing root
    }
}