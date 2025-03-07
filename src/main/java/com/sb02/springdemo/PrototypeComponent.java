package com.sb02.springdemo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeComponent {

    private final int randomInt;

    public PrototypeComponent() {
        randomInt = (int) (Math.random() * 100);
    }

    public int getRandomInt() {
        return randomInt;
    }
}
