package com.jobly.Jobly.controller;

import com.jobly.Jobly.model.employer.Employer;
import com.jobly.Jobly.model.employer.EmployerDto;
import com.jobly.Jobly.model.user.MyUser;
import com.jobly.Jobly.service.EmployerService;
import com.jobly.Jobly.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployerRestController {

    private final EmployerService employerService;
    private final MyUserService myUserService;

    @GetMapping("/employer")
    public List<Employer> getAllEmployers() {
        return employerService.getAll();
    }

    @PostMapping("/employer")
    public void createEmployer(@RequestBody EmployerDto employerDto, @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal) {
//        org.springframework.security.core.userdetails.User principal = ((org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        System.out.println(principal.getUsername());
        Employer newEmployer = Employer.builder() // TODO: przenieść do employerDTO
                .myUser(myUserService.getByEmail(principal.getUsername()).orElseThrow())
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
        MyUser myUser = myUserService.getByEmail(employerDto.getUserEmail()).orElseThrow();
        myUser.setEmployer(newEmployer);
        myUserService.save(myUser); // TODO: przenieść do employerService
    }
}
