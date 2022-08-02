package com.jobly.Jobly.model.user;

import com.jobly.Jobly.model.Candidate;
import com.jobly.Jobly.model.employer.Employer;
import com.jobly.Jobly.model.Role;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Candidate candidate;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
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
