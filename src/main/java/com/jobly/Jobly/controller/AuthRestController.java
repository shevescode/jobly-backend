package com.jobly.Jobly.controller;

import com.jobly.Jobly.model.Role;
import com.jobly.Jobly.model.user.MyUser;
import com.jobly.Jobly.model.user.UserDto;
import com.jobly.Jobly.service.MyUserService;
import com.jobly.Jobly.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthRestController {

    private final MyUserService myUserService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RoleService roleService;

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody UserDto userDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userDto.getEmail(), userDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
//        // add check for username exists in a DB
//        if(userService.existsByUsername(userDto.getUsername())){
//            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
//        }

        // add check for email exists in DB
        if (myUserService.existsByEmail(userDto.getEmail())) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        MyUser myUser = new MyUser(); // TODO: przenieść logikę do service
        myUser.setEmail(userDto.getEmail());
        myUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        myUser.setCreationTime(LocalDateTime.now());

        Role roles = roleService.findByName("ROLE_ADMIN").get();
        myUser.setRoles(Collections.singleton(roles));

        myUserService.save(myUser);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

    }
}
