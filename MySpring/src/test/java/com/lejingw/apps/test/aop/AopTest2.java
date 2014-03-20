package com.lejingw.apps.test.aop;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lejingw.apps.myspring.aop.impl.UserAction2;

public class AopTest2 {
	@Test
	public void test1(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop/aop2.xml");
		UserAction2 userAction2 = (UserAction2) ctx.getBean("userAction2");
		userAction2.sayBefore("world");
		ctx.destroy();
	}
	@Test
	public void test2(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop/aop2.xml");
		UserAction2 userAction2 = (UserAction2) ctx.getBean("userAction2");
		userAction2.sayBefore2("world", "!");
		ctx.destroy();
	}
}
