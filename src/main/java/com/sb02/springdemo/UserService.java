package com.sb02.springdemo;

import java.util.UUID;

public interface UserService {
    UUID registerUser(String userName);
    User getUser(UUID userId);
}
