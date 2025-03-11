package com.sb02.springdemo.service;

import com.sb02.springdemo.cache.ServiceCache;
import com.sb02.springdemo.event.UserEvent;
import com.sb02.springdemo.event.UserEventType;
import com.sb02.springdemo.repository.UserRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    // Composition
    private final UserRepository userRepository;
    private final ApplicationEventPublisher eventPublisher;

    public UserServiceImpl(
            UserRepository userRepository,
            ApplicationEventPublisher eventPublisher
    ) {
        this.userRepository = userRepository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public UUID registerUser(String userName) {
        User user = new User(UUID.randomUUID(), userName);
        userRepository.save(user);

        UserEvent event = new UserEvent(this, UserEventType.REGISTERED, "User registered: " + userName);
        eventPublisher.publishEvent(event);

        return user.id();
    }

    @Override
    @ServiceCache
    public User getUser(UUID userId) {
        return userRepository.findById(userId);
    }

    // Event-driven system architecture
}
