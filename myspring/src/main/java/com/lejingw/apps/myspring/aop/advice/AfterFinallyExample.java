package com.lejingw.apps.myspring.aop.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterFinallyExample {

    @After("com.lejingw.apps.myspring.aop.MyPointcut.methodTestPointcut()")
    public void doReleaseLock() {
    	System.out.println("AfterFinallyExample:doReleaseLock");
    }

}