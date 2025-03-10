package com.sb02.springdemo.repository;

import com.sb02.springdemo.service.User;

import java.util.UUID;

public interface UserRepository {
    void save(User user);
    User findById(UUID id);
}
