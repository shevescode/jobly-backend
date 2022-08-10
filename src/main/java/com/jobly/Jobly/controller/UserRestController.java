package com.jobly.Jobly.controller;

import com.jobly.Jobly.model.user.MyUser;
import com.jobly.Jobly.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequiredArgsConstructor
public class UserRestController {

    private final MyUserService myUserService;

    @GetMapping("/users")
    public List<MyUser> getAllUsers() {
        return myUserService.getAll();
    }

    @PostMapping("/users")
    public void createUser(@RequestBody MyUser newMyUser) {
        myUserService.save(newMyUser);
    }
}
