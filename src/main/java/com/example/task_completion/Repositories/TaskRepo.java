package com.example.task_completion.Repositories;

import com.example.task_completion.Entity.Task;
import com.example.task_completion.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, String> {

    void deleteById(String id);
}