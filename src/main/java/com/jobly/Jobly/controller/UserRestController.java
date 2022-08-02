package com.jobly.Jobly.controller;

import com.jobly.Jobly.model.user.MyUser;
import com.jobly.Jobly.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
