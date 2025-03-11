package com.sb02.springdemo.controller;

import com.sb02.springdemo.service.User;
import com.sb02.springdemo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // handler
    @PostMapping
    public ResponseEntity<UUID> registerUser(@RequestBody @Valid UserCreateDto userCreateDto) {
        return ResponseEntity.ok(userService.registerUser(userCreateDto.name()));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        UUID id = UUID.fromString(userId);
        User found = userService.getUser(id);
        return ResponseEntity.ok(found);
    }
}
