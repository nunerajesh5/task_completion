package com.example.task_completion.Service;

import com.example.task_completion.Entity.Role;
import com.example.task_completion.Entity.Task;
import com.example.task_completion.Entity.User;
import com.example.task_completion.Repositories.TaskRepo;
import com.example.task_completion.Repositories.UserRepo;
import com.example.task_completion.Utils.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthUtil authUtil;

    public Task createTask(Task task) {
        User currentUser = authUtil.getCurrentUser();
        if (currentUser.getRole() != Role.ADMIN) {
            throw new AccessDeniedException("Only ADMIN can create tasks.");
        }
        return taskRepo.save(task);
    }

    public List<Task> getTasks() {
        User user = authUtil.getCurrentUser();
        return user.getRole() == Role.ADMIN ? taskRepo.findAll() : null;
    }

    public Task getTaskById(String id) {
        return taskRepo.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task updateTask(String id, Task updatedTask) {
        User currentUser = authUtil.getCurrentUser();
        Task task = getTaskById(id);

        if (currentUser.getRole() != Role.ADMIN) {
            throw new AccessDeniedException("Not authorized to update this task.");
        }

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        return taskRepo.save(task);
    }

    public void deleteTask(String id) {
        User currentUser = authUtil.getCurrentUser();
        if (currentUser.getRole() != Role.ADMIN) {
            throw new AccessDeniedException("Only ADMIN can delete tasks.");
        }
        taskRepo.deleteById(id);
    }
}