package com.sb02.springdemo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class SingletonComponent {

    private int randomInt;

    public SingletonComponent() {
        System.out.println("SingletonComponent constructor");
    }

    @PostConstruct
    private void initRandomInt() {
        randomInt = (int) (Math.random() * 100);
    }

    public int getRandomInt() {
        return randomInt;
    }
}
