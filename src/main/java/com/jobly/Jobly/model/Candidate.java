package com.jobly.Jobly.model;

import com.jobly.Jobly.model.user.MyUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "my_user_id")
    private MyUser myUser;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Integer age;
    @NotNull
    private Integer phoneNumber;
    @NotNull
    private String location;
    @NotNull
    private String workingTime;
    private String photoSrc;
    private String description;
    private String experience;
}
