package com.jobly.Jobly.controller;

import com.jobly.Jobly.model.Candidate;
import com.jobly.Jobly.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600, allowCredentials = "true")
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
