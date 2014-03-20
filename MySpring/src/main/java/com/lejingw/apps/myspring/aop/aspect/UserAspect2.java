package com.lejingw.apps.myspring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect2 {

	@Before(value = "execution(* com.lejingw.apps.myspring.aop.impl.UserAction2.sayBefore*(*)) && args(str)", argNames="str")
	public void before(JoinPoint.StaticPart jp, String a) {
		System.out.println("=======================1:"+a);
		System.out.println(jp);
		System.out.println(jp.toLongString());
	}
	
	@Before(value = "execution(* com.lejingw.apps.myspring.aop.impl.UserAction2.sayBefore*(*,*)) && args(str, str2)", argNames="str, str2")
	public void before(JoinPoint jp, String a, String b) {
		System.out.println("=======================2:" + a);
		System.out.println(jp.getKind());
		System.out.println(jp.getTarget());
		System.out.println(jp.getThis());
		System.out.println(jp.getArgs());
		System.out.println("\t\t"+jp.getArgs()[0]);
		System.out.println(jp.getClass());
		System.out.println(jp.getSignature());
		System.out.println(jp.getSourceLocation());
		System.out.println(jp.getStaticPart());
		System.out.println(jp.toLongString());
	}
}
