package com.jobly.Jobly.controller;

import com.jobly.Jobly.model.Role;
import com.jobly.Jobly.model.user.User;
import com.jobly.Jobly.model.user.UserDto;
import com.jobly.Jobly.service.RoleService;
import com.jobly.Jobly.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthRestController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RoleService roleService;

    @PostMapping("/signin")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> authenticateUser(@RequestBody UserDto userDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userDto.getEmail(), userDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }

    @PostMapping("/signup")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto){
//        // add check for username exists in a DB
//        if(userService.existsByUsername(userDto.getUsername())){
//            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
//        }

        // add check for email exists in DB
        if(userService.existsByEmail(userDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setCreationTime(LocalDateTime.now());

        Role roles = roleService.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(roles));

        userService.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

    }
}
