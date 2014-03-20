package com.lejingw.apps.test.spel;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lejingw.apps.myspring.spel.SpELBean;

public class SpELTest2 {
	@Test
	public void testPrefixExpression() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spel/spel2.xml");
		SpELBean helloBean1 = ctx.getBean("helloBean1", SpELBean.class);
		Assert.assertEquals("#{'Hello' + world}", helloBean1.getValue());
		SpELBean helloBean2 = ctx.getBean("helloBean2", SpELBean.class);
		Assert.assertEquals("Hello World!", helloBean2.getValue());
		SpELBean helloBean3 = ctx.getBean("helloBean3", SpELBean.class);
		Assert.assertEquals("Hello World!", helloBean3.getValue());
	}
}
