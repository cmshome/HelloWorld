package com.lxk.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 切面类
 * <p>
 * @author lxk on 2016/11/28
 */
@Aspect
@Component(value = "transaction")
public class Transaction {

    @Pointcut("execution(* com.lxk.spring.aop.annotation.PersonDaoImpl.*(..))")
    private void aa() {
    }//切入点签名

    /**
     * 前置通知
     */
    @Before("aa()")
    public void beforeMethod() {
        System.out.println("before method");
    }

    /**
     * 后置通知
     */
    @AfterReturning(value = "aa()", returning = "val")
    public void afterMethod(JoinPoint joinPoint, Object val) {
        List<Person> personList = (ArrayList<Person>) val;
        if (personList != null && !personList.isEmpty()) {
            for (Person person : personList) {
                System.out.println(person.getPname());
            }
        }
        System.out.println("after method");
    }

    /**
     * 最终通知
     */
    @After("aa()")
    public void finalMethod(JoinPoint joinPoint) {
        joinPoint.getArgs();
        System.out.println("final method");
    }

    /**
     * 环绕通知
     */
    @Around("aa()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        Object obj = null;
        try {
            obj = joinPoint.proceed();
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
        System.out.println("around method");
        return obj;
    }

    /**
     * 异常通知
     */
    @AfterThrowing(value = "aa()", throwing = "ex")
    public void throwingMethod(Throwable ex) {
        System.out.println(ex.getMessage());
    }
}
