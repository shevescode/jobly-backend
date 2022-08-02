package com.jobly.Jobly.model.employer;

import com.jobly.Jobly.model.user.MyUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployerDto {

    private String userEmail;
    private String companyName;
    private String industry;
    private String position;
    private Integer salary;
    private String location;
    private String workingTime;
    private String photoSrc;
    private String optionalRequirements;

    public Employer toEmployer(MyUser myUser) {
        return Employer.builder()
                .myUser(myUser)
                .companyName(companyName)
                .industry(industry)
                .position(position)
                .salary(salary)
                .location(location)
                .workingTime(workingTime)
                .photoSrc(photoSrc)
                .optionalRequirements(optionalRequirements)
                .build();
    }
}
