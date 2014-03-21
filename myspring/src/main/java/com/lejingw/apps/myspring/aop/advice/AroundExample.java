package com.lejingw.apps.myspring.aop.advice;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundExample {

    @Around("com.lejingw.apps.myspring.aop.MyPointcut.methodTestPointcut()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("start stopwatch");
        Object retVal = pjp.proceed();
        System.out.println("stop stopwatch");
        return retVal;
    }

}