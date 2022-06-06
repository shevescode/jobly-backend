package com.jobly.Jobly.controller;

import com.jobly.Jobly.model.Candidate;
import com.jobly.Jobly.model.Employer;
import com.jobly.Jobly.service.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployerRestController {

    private final EmployerService employerService;

    @GetMapping("/employer")
    public List<Employer> getAllEmployers() {
        return employerService.getAll();
    }
}
