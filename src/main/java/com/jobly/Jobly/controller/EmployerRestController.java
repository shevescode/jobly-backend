package com.jobly.Jobly.controller;

import com.jobly.Jobly.model.employer.Employer;
import com.jobly.Jobly.model.employer.EmployerDto;
import com.jobly.Jobly.model.user.MyUser;
import com.jobly.Jobly.service.EmployerService;
import com.jobly.Jobly.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequiredArgsConstructor
public class EmployerRestController {

    private final EmployerService employerService;
    private final MyUserService myUserService;

    @GetMapping("/employer")
    public List<Employer> getAllEmployers() {
        return employerService.getAll();
    }

    @PostMapping("/employer")
    public ResponseEntity<?> createEmployer(@RequestBody EmployerDto employerDto, @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal) {
        MyUser myUser = myUserService.getByEmail(principal.getUsername()).orElseThrow();
        Employer newEmployer = employerDto.toEmployer(myUser);
        employerService.createEmployer(newEmployer, myUser);
        return new ResponseEntity<>("Employer created", HttpStatus.OK);
    }
}
