package com.jobly.Jobly.controller;

import com.jobly.Jobly.model.candidate.Candidate;
import com.jobly.Jobly.model.candidate.CandidateDTO;
import com.jobly.Jobly.model.employer.Employer;
import com.jobly.Jobly.service.CandidateService;
import com.jobly.Jobly.model.user.MyUser;
import com.jobly.Jobly.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600, allowCredentials = "true")
@RequiredArgsConstructor
public class CandidateRestController {

    private final CandidateService candidateService;
    private final MyUserService myUserService;

    @GetMapping("/candidate")
    public List<Candidate> getAllCandidates() {
        return candidateService.getAll();
    }

    @PostMapping("/candidate")
    public void createCandidate(@RequestBody CandidateDTO candidateDto, @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal) {
        MyUser myUser = myUserService.getByEmail(principal.getUsername()).orElseThrow();
        Candidate newCandidate = candidateDto.toCandidate(myUser);

        candidateService.createCandidate(newCandidate, myUser);
    }
}
