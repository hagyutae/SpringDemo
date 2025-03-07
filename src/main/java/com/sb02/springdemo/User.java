package com.sb02.springdemo;

import java.util.UUID;

public record User(
        UUID id,
        String name
) {
}
