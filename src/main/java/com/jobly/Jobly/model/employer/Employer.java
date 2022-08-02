package com.jobly.Jobly.model.employer;

import com.jobly.Jobly.model.user.MyUser;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "my_user_id")
    private MyUser myUser;
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
