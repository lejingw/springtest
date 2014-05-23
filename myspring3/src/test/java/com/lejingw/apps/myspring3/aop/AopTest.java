package com.lejingw.apps.myspring3.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

	private static String configLocation = "classpath:com/lejingw/apps/myspring3/aop/aop.xml";
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			configLocation);

	@Test
	public void afterReturnTest() {
		MethodTestBean bean = (MethodTestBean) ctx.getBean("methodTestBean");
		bean.returnRetVal();
		bean.returnObject();
		bean.returnVoid();
	}

	@Test(expected = DataAccessException.class)
	public void afterThrowTest() {
		MethodTestBean bean = (MethodTestBean) ctx.getBean("methodTestBean");
		bean.throwDataAccessException();
	}

	@Test(expected = DataAccessException.class)
	public void afterFinallyTest() {
		MethodTestBean bean = (MethodTestBean) ctx.getBean("methodTestBean");
		bean.returnRetVal();
		bean.throwDataAccessException();
	}
}
