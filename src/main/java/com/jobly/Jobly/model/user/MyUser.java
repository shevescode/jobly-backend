package com.jobly.Jobly.model.user;

import com.jobly.Jobly.model.candidate.Candidate;
import com.jobly.Jobly.model.Role;
import com.jobly.Jobly.model.employer.Employer;
import lombok.*;

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
@Builder
@ToString
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(mappedBy = "myUser", cascade = CascadeType.ALL)
    private Candidate candidate;
    @OneToOne(mappedBy = "myUser", cascade = CascadeType.ALL)
    private Employer employer;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    private LocalDateTime creationTime;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "my_user_roles",
            joinColumns = @JoinColumn(name = "my_user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;
}
