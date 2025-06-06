package com.example.task_completion.Service;

import com.example.task_completion.Entity.Role;
import com.example.task_completion.Entity.User;
import com.example.task_completion.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<User> getAllusers() {
        return userRepo.findAll();
    }

    public Boolean createUser(User userEntry) {
        try {
            userEntry.setPassword(passwordEncoder.encode(userEntry.getPassword()));
            userRepo.save(userEntry);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Optional<User> getByUserName(String userName) {
        return Optional.ofNullable(userRepo.findByUsername(userName));
    }

    public Object updateUser(User userEntry1) {
        return userRepo.save(userEntry1);
    }

    public void deleteUserByUserName(String userName) {
        userRepo.deleteByUsername(userName);
    }
}