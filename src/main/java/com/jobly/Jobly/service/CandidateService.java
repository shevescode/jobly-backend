package com.jobly.Jobly.service;

import com.jobly.Jobly.model.candidate.Candidate;
import com.jobly.Jobly.model.user.MyUser;
import com.jobly.Jobly.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final MyUserService myUserService;

    public List<Candidate> getAll() {
        return candidateRepository.findAll();
    }

    public void createUser(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    public void createCandidate(Candidate newCandidate, MyUser myUser) {
        candidateRepository.save(newCandidate);
        myUser.setCandidate(newCandidate);
        myUserService.save(myUser);
    }
}
