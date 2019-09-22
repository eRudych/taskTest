package com.example.demo.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class LoggerAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);


    @Pointcut("within(com.example.demo.*.*)")
    public void pointcutForDemo() {
    }

    @After("pointcutForDemo()")
    public void logMethodCallForController(JoinPoint jp) {
        String className = jp.getTarget().getClass().toString();
        String methodName = jp.getSignature().getName();
        logger.info("LogInfo: " + className + " method - " + methodName);
    }

    @AfterThrowing(pointcut = "pointcutForDemo()", throwing = "ex")
    public void logError(JoinPoint jp, Exception ex) {
        String className = jp.getTarget().getClass().toString();
        String methodName = jp.getSignature().getName();
        logger.error("LogError: " + className + " method - " + methodName + " exception - " + ex);
    }
}
