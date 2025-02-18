package com.example.ecommerce.controller;

import com.example.ecommerce.model.User;
import com.example.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return "User registered successfully";
    }

    @PostMapping(value = "/login", consumes = "application/x-www-form-urlencoded")
    public String loginUserFormUrlEncoded(@RequestParam String email, @RequestParam String password) {
        Optional<User> loggedInUser = userService.loginUser(email, password);
        return loggedInUser.isPresent() ? "Login successful" : "Invalid email or password";
    }

    @PostMapping(value = "/login", consumes = "application/json")
    public String loginUserJson(@RequestBody User user) {
        Optional<User> loggedInUser = userService.loginUser(user.getEmail(), user.getPassword());
        return loggedInUser.isPresent() ? "Login successful" : "Invalid email or password";
    }
}
