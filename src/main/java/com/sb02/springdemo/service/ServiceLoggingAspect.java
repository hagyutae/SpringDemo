package com.sb02.springdemo.service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLoggingAspect {

    @Before("execution(* com.sb02.springdemo.service.UserServiceImpl.registerUser(..))")
    public void beforeRegisterUser() {
        System.out.println("Before registerUser");
    }

    @After("execution(* com.sb02.springdemo.service.UserServiceImpl.registerUser(..))")
    public void afterRegisterUser() {
        System.out.println("After registerUser");
    }
}
