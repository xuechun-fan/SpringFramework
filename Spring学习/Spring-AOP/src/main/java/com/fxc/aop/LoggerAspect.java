package com.fxc.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect     //  表示该类是切面类
@Component  //  表示将该类的对象注入到Ioc容器中
public class LoggerAspect {

    //  @Before 表示方法执行的具体位置和时机
    @Before("execution(public int com.fxc.impl.CalImpl.*(..))")
    public void before(JoinPoint joinPoint){
        //  获取方法名
        String name = joinPoint.getSignature().getName();
        //  获取参数
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(name + "方法的参数是" + args);
    }

    @After("execution(public int com.fxc.impl.CalImpl.*(..))")
    public void after(JoinPoint joinPoint){
        //  获取方法名
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法执行完毕");
    }

    @AfterReturning(value = "execution(public int com.fxc.impl.CalImpl.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        //  获取方法名
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法的结果是：" + result);
    }

    @AfterThrowing(value = "execution(public int com.fxc.impl.CalImpl.*(..))", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception){
        //  获取方法名
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法抛出异常" + exception);
    }
}
