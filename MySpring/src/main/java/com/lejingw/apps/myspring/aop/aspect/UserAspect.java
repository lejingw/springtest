package com.lejingw.apps.myspring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.lejingw.apps.myspring.aop.IIntroductionService;

/**
 * 
 * @author Administrator
 * 通过aop拦截后执行具体操作
 */
@Aspect
@Component
public class UserAspect {
	@DeclareParents(value="com.lejingw.apps.myspring.aop.UserAction", defaultImpl=com.lejingw.apps.myspring.aop.impl.IntroductiondService.class)
	private IIntroductionService introductionService;
	
	@Pointcut(value="execution(public * com.lejingw.apps.myspring.aop..*.*(..)) && args(p)", argNames="p")
	public void recordLog(String pp){}
	
	
	@Before(value="recordLog(pp)", argNames="pp")
//	@Before("execution(public * com.lejingw.apps.myspring.aop..*.*(..))")
	public void before(String ab) {
		this.printLog("============before:" + ab);
	}
	
	@Around("recordLog(java.lang.String)")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		this.printLog("============around start");
		Object obj = pjp.proceed();
		this.printLog("============around end");
		return obj;
	}
	
	
	@After("recordLog(java.lang.String)")
	public void after() {
		this.printLog("============after");
	}
	
	@AfterReturning(value="recordLog(java.lang.String)", argNames="a", returning="a")
	public void afterReturning(Object p1) {
		this.printLog("============afterReturning");
		this.printLog("p1:"+ p1);
	}
	
	@AfterReturning(value="recordLog(p)", argNames="a, p", returning="a")
	public void afterReturning2(Object p1, String p2) {
		this.printLog("============afterReturning2");
		this.printLog("p1:" + p1 + ", p2:"+ p2);
	}
	
	@AfterThrowing(value="recordLog(p)", argNames="p, e", throwing="e")
	public void afterThrowing(String p1, Exception p2){
		this.printLog("============afterThrowing");
		this.printLog("p1:" + p1 + ", p2:"+ p2);
	}
	
	
	private void printLog(String str){
		System.out.println(str);
	}
}