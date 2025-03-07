package com.sb02.springdemo;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

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
    public User getUser(UUID userId) {
        return userRepository.findById(userId);
    }

    // Event-driven system architecture
}
