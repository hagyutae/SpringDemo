package com.sb02.springdemo.cache;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
@Order(2)
public class ServiceCacheAspect {

    private final Map<String, Object> cache = new ConcurrentHashMap<>();

    @Around("@annotation(com.sb02.springdemo.cache.ServiceCache)")
    public Object cacheResult(ProceedingJoinPoint joinPoint) throws Throwable {
        String cacheKey = generateKey(joinPoint);

        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }

        Object result = joinPoint.proceed();

        cache.put(cacheKey, result);
        return result;
    }

    private String generateKey(ProceedingJoinPoint joinPoint) {
        StringBuilder key = new StringBuilder();
        key.append(joinPoint.getSignature().toShortString());
        for (Object arg : joinPoint.getArgs()) {
            key.append("-").append(arg.toString());
        }
        return key.toString();
    }
}
