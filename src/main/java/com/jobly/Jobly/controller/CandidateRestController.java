package com.jobly.Jobly.controller;

import com.jobly.Jobly.model.Candidate;
import com.jobly.Jobly.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CandidateRestController {

    private final CandidateService candidateService;

    @GetMapping("/candidate")
    public List<Candidate> getAllCandidates() {
        return candidateService.getAll();
    }

    @PostMapping("/candidate")
    public void createCandidate(@RequestBody Candidate candidate) {
        candidateService.createUser(candidate);
    }
}
