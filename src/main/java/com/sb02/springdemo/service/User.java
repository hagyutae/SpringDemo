package com.sb02.springdemo.service;

import java.util.UUID;

public record User(
        UUID id,
        String name
) {
}
