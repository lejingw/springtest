package com.lejingw.apps.test.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lejingw.apps.myspring.aop.IHelloWorldService;
import com.lejingw.apps.myspring.aop.IIntroductionService;
import com.lejingw.apps.myspring.aop.impl.UserAction;

public class AopTest {

	@Test
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/aop.xml");
		IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
		helloworldService.sayHello();
	}

	@Test
	public void test2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/aop.xml");
		IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
		helloworldService.sayBefore("aaaabbbc");
	}

	@Test(expected = RuntimeException.class)
	public void test3() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/aop.xml");
		IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
		helloworldService.sayAfterThrowing("abcdefg");
	}

	@Test
	public void test4() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/aop.xml");
		IIntroductionService introductionService = ctx.getBean("helloWorldService", IIntroductionService.class);
		introductionService.induct();
	}

	@Test
	public void test21() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop/aop2.xml");
		UserAction userAction = (UserAction) ctx.getBean("userAction");
		userAction.queryUsers("abcde");
		ctx.destroy();
	}
	
	@Test(expected=RuntimeException.class)
	public void test22() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop/aop2.xml");
		UserAction userAction = (UserAction) ctx.getBean("userAction");
		userAction.queryUsers2("abcde");
		ctx.destroy();
	}
	@Test
	public void test23() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop/aop2.xml");
		IIntroductionService introductionService = ctx.getBean("userAction", IIntroductionService.class);
		introductionService.induct();
		ctx.destroy();
	}

	@Test
	public void test31() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/aop3.xml");
		IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
		helloworldService.sayAdvisorBefore("haha");
	}
}