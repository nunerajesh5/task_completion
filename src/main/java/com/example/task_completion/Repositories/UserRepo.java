package com.example.task_completion.Repositories;

import com.example.task_completion.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    User findByUsername(String username);

    void deleteByUsername(String username);

}