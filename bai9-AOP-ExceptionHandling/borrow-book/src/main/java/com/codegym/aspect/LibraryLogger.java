package com.codegym.aspect;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LibraryLogger {
    private int visitCount = 0;

    @Before("execution(* com.codegym.controller.*.*(..))")
    public void logVisit(JoinPoint jp) {
        visitCount++;
        System.out.println("Truy cập #" + visitCount + ": " + jp.getSignature().toShortString());
    }

    @After("execution(* com.codegym.service.LibraryService.borrow(..)) || execution(* com.codegym.service.LibraryService.returnBook(..))")
    public void logChange(JoinPoint jp) {
        System.out.println("Trạng thái sách thay đổi: " + jp.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(* com.codegym.service.*.*(..))", throwing = "ex")
    public void logError(JoinPoint jp, Throwable ex) {
        System.err.println("Lỗi tại " + jp.getSignature().toShortString() + ": " + ex.getMessage());
    }
}
