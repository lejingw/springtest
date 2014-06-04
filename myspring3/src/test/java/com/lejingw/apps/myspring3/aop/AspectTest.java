package com.lejingw.apps.myspring3.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lejingw.apps.myspring3.aop.aspect.MyComponent;
import com.lejingw.apps.myspring3.aop.aspect.MyException;

public class AspectTest {

	private static String configLocation = "classpath:com/lejingw/apps/myspring3/aop/aspect.xml";
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			configLocation);

	@Test
	public void afterReturnTest() {
		MyComponent bean = (MyComponent) ctx.getBean("myComponent");
//		bean.returnRetVal();
//		bean.returnObject();
		bean.returnVoid();
	}

	@Test(expected = MyException.class)
	public void afterThrowTest() {
		MyComponent bean = (MyComponent) ctx.getBean("myComponent");
		bean.throwMyException();
	}

	@Test(expected = MyException.class)
	public void afterFinallyTest() {
		MyComponent bean = (MyComponent) ctx.getBean("myComponent");
		bean.returnRetVal();
		bean.throwMyException();
	}
}
