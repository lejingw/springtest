package com.lejingw.apps.myspring3.aop.aspect.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.lejingw.apps.myspring3.aop.aspect.MyException;
import com.lejingw.apps.myspring3.aop.aspect.MyObject;

@Component
@Aspect
public class AllAspect {

	@Around("com.lejingw.apps.myspring3.aop.aspect.pointcut.MyPointcut.methodTestPointcut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("----around start----");
		Object retVal = pjp.proceed();
		System.out.println("----around stop----");
		return retVal;
	}

	@AfterReturning(pointcut = "com.lejingw.apps.myspring3.aop.aspect.pointcut.MyPointcut.methodTestPointcut()", returning = "retVal")
	public void afterReturning(MyObject retVal) {
		System.out.println("----after returning----" + retVal);
	}

	@After("com.lejingw.apps.myspring3.aop.aspect.pointcut.MyPointcut.methodTestPointcut()")
	public void afterFinally() {
		System.out.println("----after finally----");
	}

	@AfterThrowing(pointcut = "com.lejingw.apps.myspring3.aop.aspect.pointcut.MyPointcut.methodTestPointcut()", throwing = "ex")
	public void afterThrowing(MyException ex) {
		System.out.println("----after throwing----" + ex.getMessage());
	}
}