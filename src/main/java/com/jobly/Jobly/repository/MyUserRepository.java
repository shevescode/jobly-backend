package com.jobly.Jobly.repository;

import com.jobly.Jobly.model.user.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Long> {

    Optional<MyUser> findByEmail(String email);

    Boolean existsByEmail(String email);
}
