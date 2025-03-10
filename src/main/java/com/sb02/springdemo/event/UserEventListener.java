package com.sb02.springdemo.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventListener {

    // Event-driven programming, loosely coupled
    @EventListener
    public void sendNotification(UserEvent userEvent) {
        System.out.println("User event received: " + userEvent.getEventType() + " " + userEvent.getMessage());
    }

    @EventListener
    public void increaseUserCount(UserEvent userEvent) {
        System.out.println("User event received 2");
    }
}
