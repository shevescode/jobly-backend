package com.jobly.Jobly.model.user;

import com.jobly.Jobly.model.Candidate;
import com.jobly.Jobly.model.Employer;
import com.jobly.Jobly.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Candidate candidate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employer_id", referencedColumnName = "id")
    private Employer employer;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    private LocalDateTime creationTime;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;
}
