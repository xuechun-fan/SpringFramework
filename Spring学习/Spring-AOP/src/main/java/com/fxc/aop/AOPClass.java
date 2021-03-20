package com.fxc.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AOPClass {
    @Before("execution(public int com.fxc.impl.ShowInfo.*(..))")
    public void beforeExecution(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(name + "方法的参数是：" + args);
    }
}
