package com.sb02.springdemo.logging;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(1)
public class CustomLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(CustomLoggingAspect.class);

    @Around("@annotation(com.sb02.springdemo.logging.CustomLogging)")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();
        String args = Arrays.stream(joinPoint.getArgs()).map(Object::toString).toList().toString();

        logger.info("Method {} called with arguments {}", methodName, args);

        Object result = joinPoint.proceed();

        logger.info("Method {} returned {}", methodName, result);

        return result;
    }
}
