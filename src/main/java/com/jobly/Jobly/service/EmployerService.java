package com.jobly.Jobly.service;

import com.jobly.Jobly.model.employer.Employer;
import com.jobly.Jobly.repository.EmployerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployerService {

    private final EmployerRepository employerRepository;

    public List<Employer> getAll() {
        return employerRepository.findAll();
    }

    public void createEmployer(Employer employer) {
        employerRepository.save(employer);
    }
}