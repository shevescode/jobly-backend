package com.jobly.Jobly.model.employer;

import com.jobly.Jobly.model.user.MyUser;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
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

    public static EmployerDto fromEmployer(Employer employer) {
        return EmployerDto.builder()
                .companyName(employer.getCompanyName())
                .industry(employer.getIndustry())
                .position(employer.getPosition())
                .salary(employer.getSalary())
                .location(employer.getLocation())
                .workingTime(employer.getWorkingTime())
                .photoSrc(employer.getPhotoSrc())
                .optionalRequirements(employer.getOptionalRequirements())
                .build();

    }
}
