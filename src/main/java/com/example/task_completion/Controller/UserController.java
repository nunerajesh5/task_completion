package com.example.task_completion.Controller;

import com.example.task_completion.Entity.User;
import com.example.task_completion.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/me")
    public ResponseEntity<User> fetchUser(@RequestBody User request) {
        Optional<User> optionalUser = userService.getByUserName(request.getUsername());
        return optionalUser.map(user -> ResponseEntity.ok(user))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}