package com.sb02.springdemo.service;

import java.util.UUID;

public interface UserService {
    UUID registerUser(String userName);
    User getUser(UUID userId);
}
