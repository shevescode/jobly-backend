package com.jobly.Jobly.controller;

import com.jobly.Jobly.model.employer.Employer;
import com.jobly.Jobly.model.employer.EmployerDto;
import com.jobly.Jobly.model.user.User;
import com.jobly.Jobly.service.EmployerService;
import com.jobly.Jobly.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequiredArgsConstructor
public class EmployerRestController {

    private final EmployerService employerService;
    private final UserService userService;

    @GetMapping("/employer")
    public List<Employer> getAllEmployers() {
        return employerService.getAll();
    }

    @PostMapping("/employer")
    public void createEmployer(@RequestBody EmployerDto employerDto) {
        System.out.println("weszło tutaj");
        System.out.println(employerDto.toString());
        Employer newEmployer = Employer.builder()
                .user(userService.getByEmail(employerDto.getUserEmail()).orElseThrow())
                .companyName(employerDto.getCompanyName())
                .industry(employerDto.getIndustry())
                .position(employerDto.getPosition())
                .salary(employerDto.getSalary())
                .location(employerDto.getLocation())
                .workingTime(employerDto.getWorkingTime())
                .photoSrc(employerDto.getPhotoSrc())
                .optionalRequirements(employerDto.getOptionalRequirements())
                .build();

        employerService.createEmployer(newEmployer);
        User user = userService.getByEmail(employerDto.getUserEmail()).orElseThrow();
        user.setEmployer(newEmployer);
        userService.save(user);
    }
}
