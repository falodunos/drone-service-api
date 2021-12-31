package com.drone.manager.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import java.lang.reflect.Method;

@Slf4j
public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... obj) {
        log.info("Exception Message - {}", ex.getMessage());
        log.info("Method name - {}", method.getName());

        for (final Object param: obj) {
            log.info("Param - {}" + param);
        }
    }
}
