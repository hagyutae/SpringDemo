package com.sb02.springdemo.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventNotifier {

    // Event: Publisher, Subscriber (Listener, Handler)
    // Event-driven programming, loosely coupled
    @EventListener
    public void sendNotification(UserEvent userEvent) {
        System.out.println("User event received: " + userEvent.getEventType() + " " + userEvent.getMessage());
    }
}
