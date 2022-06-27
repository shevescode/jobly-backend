package com.jobly.Jobly.controller;

import com.jobly.Jobly.model.User;
import com.jobly.Jobly.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User newUser) {
        userService.createUser(newUser);
    }
}
