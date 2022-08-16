package com.jobly.Jobly.model.candidate;


import com.jobly.Jobly.model.user.MyUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateDTO {

    private String firstName;
    private String lastName;
    private Integer age;
    private Integer phoneNumber;
    private String location;
    private String workingTime;
    private String photoSrc;
    private String description;
    private String experience;

    public Candidate toCandidate(MyUser myUser) {
        return Candidate.builder()
                .myUser(myUser)
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .phoneNumber(phoneNumber)
                .location(location)
                .workingTime(workingTime)
                .photoSrc(photoSrc)
                .description(description)
                .experience(experience)
                .build();
    }

}
