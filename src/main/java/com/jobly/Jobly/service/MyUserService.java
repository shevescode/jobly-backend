package com.jobly.Jobly.service;

import com.jobly.Jobly.model.user.MyUser;
import com.jobly.Jobly.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserService {

    private final MyUserRepository myUserRepository;

    public List<MyUser> getAll() {
        return myUserRepository.findAll();
    }

    public Optional<MyUser> getByEmail(String email) {
        return myUserRepository.findByEmail(email);
    }

    public void save(MyUser myUser) {
        myUserRepository.save(myUser);
    }

    public boolean existsByEmail(String email) {
        return myUserRepository.existsByEmail(email);
    }
}
