package com.jobly.Jobly.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(mappedBy = "employer")
    private User user;
    @NotNull
    private String companyName;
    @NotNull
    private String industry;
    @NotNull
    private String position;
    @NotNull
    private Integer salary;
    @NotNull
    private String location;
    @NotNull
    private String workingTime;
    private String photoSrc;
    private String optionalRequirements;
}
