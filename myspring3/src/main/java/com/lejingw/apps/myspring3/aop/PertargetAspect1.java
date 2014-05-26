package com.lejingw.apps.myspring3.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;

import com.lejingw.apps.myspring3.aop.service.IIntroductionService;
import com.lejingw.apps.myspring3.aop.service.impl.IntroductiondService;

@Aspect("pertarget(target(com.lejingw.apps.myspring3.aop.service.IIntroductionService))")
public class PertargetAspect1 {

	private int counter = 1;

	@DeclareParents(value = "com.lejingw.apps.myspring3.aop..IPointcutService+", defaultImpl = IntroductiondService.class)
	private IIntroductionService introductionService;

	@Before(value = "execution(public * *(..))")
	public void executionTest1(JoinPoint jp) {
		System.out
				.println("============pertarget(target(cn.javass.spring.chapter6.service.IIntroductionService)):"
						+ counter++);
	}

}
