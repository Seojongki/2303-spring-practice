package com.tj.edu.practice4.aop.aops;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ParameterAop {

    @Pointcut("execution(* com.tj.edu.practice4.aop.controller..*.*(..)) ")
    private void cut1() {}

    @Before("cut1()")
    public void before(JoinPoint joinPoint){
        System.out.println("aop의 befor가 실행됨");
    }

    @AfterReturning(value = "cut1()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj){
        System.out.println("aop의 AfterReturning이 실행됨");
        System.out.println(returnObj);
    }

}
