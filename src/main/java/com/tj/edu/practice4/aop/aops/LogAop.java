package com.tj.edu.practice4.aop.aops;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAop {
    @Pointcut("execution(* com.tj.edu.practice4.aop.controller..*.*(..)) ")
    private void logPointCut() {}

    @Before("logPointCut()")
    public void beforeLogAop(JoinPoint joinPoint){
        System.out.println("logPointCut before가 실행됨");
    }

    @After("logPointCut()")
    public void aferPointCut(JoinPoint joinPoint){
        System.out.println("logPointCut afer가 실행됨");
    }


}
