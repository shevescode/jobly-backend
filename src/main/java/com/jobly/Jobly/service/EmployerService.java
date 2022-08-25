package com.jobly.Jobly.service;

import com.jobly.Jobly.model.employer.Employer;
import com.jobly.Jobly.model.user.MyUser;
import com.jobly.Jobly.repository.EmployerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployerService {

    private final EmployerRepository employerRepository;
    private final MyUserService myUserService;

    public List<Employer> getAll() {
        return employerRepository.findAll();
    }

    public Employer getEmployer(long id) {
       return employerRepository.findById(id).orElseThrow();
    }

    public void createEmployer(Employer employer, MyUser myUser) {
        employerRepository.save(employer);
        myUser.setEmployer(employer);
        myUserService.save(myUser);
    }
}