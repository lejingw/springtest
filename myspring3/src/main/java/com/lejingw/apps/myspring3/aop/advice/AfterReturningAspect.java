package com.lejingw.apps.myspring3.aop.advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.lejingw.apps.myspring3.aop.RetVal;

@Component
@Aspect
public class AfterReturningAspect {
	
    @AfterReturning(
        pointcut="com.lejingw.apps.myspring3.aop.MyPointcut.methodTestPointcut()",
        returning="retVal")
    public void doAccessCheck(RetVal retVal) {
        System.out.println(retVal);
    }

}