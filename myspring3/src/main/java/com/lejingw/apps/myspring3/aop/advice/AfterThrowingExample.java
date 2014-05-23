package com.lejingw.apps.myspring3.aop.advice;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.lejingw.apps.myspring3.aop.DataAccessException;

@Component
@Aspect
public class AfterThrowingExample {

	@AfterThrowing(pointcut = "com.lejingw.apps.myspring3.aop.MyPointcut.methodTestPointcut()", throwing = "ex")
	public void doRecoveryActions(DataAccessException ex) {
		System.out.println(ex.getMessage());
	}

}