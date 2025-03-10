package com.sb02.springdemo.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventLogger {

    @EventListener
    public void sendUserEventLog(UserEvent userEvent) {
        System.out.println("send user event log to timeseries DB: " + userEvent.getEventType() + " " + userEvent.getMessage());
    }
}
