package com.sb02.springdemo;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventListener {

    // Event-driven programming, loosely coupled
    @EventListener
    public void handleUserEvent(UserEvent userEvent) {
        System.out.println("User event received: " + userEvent.getEventType() + " " + userEvent.getMessage());
    }

    @EventListener
    public void handleUserEvent2(UserEvent userEvent) {
        System.out.println("User event received 2");
    }
}
