package com.lejingw.apps.myspring.aop.advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.lejingw.apps.myspring.aop.RetVal;

@Component
@Aspect
public class AfterReturningAspect {
	
    @AfterReturning(
        pointcut="com.lejingw.apps.myspring.aop.MyPointcut.methodTestPointcut()",
        returning="retVal")
    public void doAccessCheck(RetVal retVal) {
        System.out.println(retVal);
    }

}