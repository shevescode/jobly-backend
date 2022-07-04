package com.jobly.Jobly.model.employer;

import lombok.Getter;
import lombok.Setter;;

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
}
