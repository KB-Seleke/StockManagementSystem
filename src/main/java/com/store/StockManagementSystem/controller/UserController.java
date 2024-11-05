package com.store.StockManagementSystem.controller;

import com.store.StockManagementSystem.model.User;
import com.store.StockManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        Optional<User> userOptional = userService.findByUsername(username);
        return userOptional.map(ResponseEntity::ok)
                           .orElseGet(() -> ResponseEntity.status(404).body(null));
    }
}
