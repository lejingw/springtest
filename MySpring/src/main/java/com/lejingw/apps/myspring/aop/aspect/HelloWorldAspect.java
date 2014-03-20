package com.lejingw.apps.myspring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class HelloWorldAspect {
	// 前置通知
	public void beforeAdvice() {
		System.out.println("===========before advice");
	}
	
	public void afterReturnAdvice(Object rtnVal){
		System.out.println("===========after return advice:" + rtnVal);
	}

	// 后置最终通知
	public void afterFinallyAdvice() {
		System.out.println("===========after finally advice");
	}
	
	// 环绕通知
	public Object aroundAdvice(ProceedingJoinPoint pjp)throws Throwable{
		System.out.println("-------around before-------");
		Object obj = pjp.proceed();
		System.out.println("-------around after-------");
		return obj;
	}
	
	public void beforeAdvice2(String ab){
		System.out.println("===========before advice with param:"+ab);
	}
	
	public void afterThrowingAdvice(Exception exception, String c) {  
		  System.out.println("===========after throwing advice exception:" + exception + ",c:"+c);  
		} 
}