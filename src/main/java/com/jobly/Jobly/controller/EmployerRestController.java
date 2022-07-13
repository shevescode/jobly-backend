package com.jobly.Jobly.controller;

import com.jobly.Jobly.model.employer.Employer;
import com.jobly.Jobly.model.employer.EmployerDto;
import com.jobly.Jobly.model.user.User;
import com.jobly.Jobly.service.EmployerService;
import com.jobly.Jobly.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
