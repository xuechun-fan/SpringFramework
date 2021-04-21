package com.fxc.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 使用注解实现AOP
 */
@Aspect //标注这个类是一个切面
public class AnnotationPointCut {
    @Before("execution(* com.fxc.service.UserService.*(..))")
    public void before(){
        System.out.println("============方法执行前============");
    }

    @After("execution(* com.fxc.service.UserService.*(..))")
    public void after(){
        System.out.println("************方法执行后************");
    }
    //  在环绕增强中，我们可以给定一个参数，代表我们获取处理切入的点
    @Around("execution(* com.fxc.service.UserService.*(..))")
    public void around(ProceedingJoinPoint point){
        System.out.println("-------环绕前-------");
        try {
            //  执行方法
            Object proceed = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("***********环绕后***********");

    }
}