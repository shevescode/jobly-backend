package com.jobly.Jobly.repository;

import com.jobly.Jobly.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
