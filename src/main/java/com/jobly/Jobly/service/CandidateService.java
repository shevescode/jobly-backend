package com.jobly.Jobly.service;

import com.jobly.Jobly.model.Candidate;
import com.jobly.Jobly.model.User;
import com.jobly.Jobly.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public List<Candidate> getAll() {
        return candidateRepository.findAll();
    }

    public void createUser(Candidate candidate) {
        candidateRepository.save(candidate);
    }
}
