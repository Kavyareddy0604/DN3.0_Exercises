package org.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* org.library.services.BookServices.listBooks(..))")
    public void logBefore() {
        System.out.println("LoggingAspect: Before method execution");
    }

    @After("execution(* org.library.services.BookServices.listBooks(..))")
    public void logAfter() {
        System.out.println("LoggingAspect: After method execution");
    }
}
