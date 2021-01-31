package com.exercise.springpractice.controller;

import java.util.List;

import com.exercise.springpractice.model.User;
import com.exercise.springpractice.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAllUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        log.info("Add User To Database: {}", user);
        return ResponseEntity.ok(userService.createUser(user));
    }
}
