package com.sb02.springdemo.event;

import org.springframework.context.ApplicationEvent;

// 사건의 발생을 알려주기 위한 매개체, 메세지
public class UserEvent extends ApplicationEvent {

    private final UserEventType eventType;
    private final String message;

    public UserEvent(Object source, UserEventType eventType, String message) {
        super(source);
        this.eventType = eventType;
        this.message = message;
    }

    public UserEventType getEventType() {
        return eventType;
    }

    public String getMessage() {
        return message;
    }
}
