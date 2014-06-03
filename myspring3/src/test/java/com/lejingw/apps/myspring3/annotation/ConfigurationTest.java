package com.lejingw.apps.myspring3.annotation;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lejingw.apps.myspring3.annotation.bean.HelloApi;
import com.lejingw.apps.myspring3.annotation.conf.ApplicationContextConfig;
import com.lejingw.apps.myspring3.annotation.conf.ApplicationContextConfig2;

public class ConfigurationTest {

	@Test
	public void testHelloworld() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				ApplicationContextConfig.class);
		Assert.assertEquals("hello", ctx.getBean("message"));
		Assert.assertNotNull(ctx.getBean("ctxConfig"));
	}

	@Test
	public void testDependencyInject() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				ApplicationContextConfig.class);
		ctx.getBean("helloImpl3", HelloApi.class).sayHello();
		ctx.getBean("helloImpl4", HelloApi.class).sayHello();
	}

	@Test
	public void testLookupMethodInject() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
		System.out.println("=======prototype sayHello======");
		HelloApi helloApi2 = ctx.getBean("helloApi2", HelloApi.class);
		helloApi2.sayHello();
		helloApi2 = ctx.getBean("helloApi2", HelloApi.class);
		helloApi2.sayHello();
	}

	@Test
	public void testImportResource() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
		Assert.assertEquals("test", ctx.getBean("message3"));
	}

	@Test
	public void testImport() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationContextConfig2.class);
		Assert.assertEquals("hello", ctx.getBean("message"));
		Assert.assertEquals("hello", ctx.getBean("message2"));
	}

	@Test
	public void testXmlConfig() {
		String configLocations[] = { "classpath:com/lejingw/apps/myspring3/annotation/importResource.xml" };
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocations);
		Assert.assertEquals("test", ctx.getBean("message3"));
	}

	public void testMultipleConfig() {
		AnnotationConfigApplicationContext ctx1 = new AnnotationConfigApplicationContext(ApplicationContextConfig.class, ApplicationContextConfig2.class);

		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext();
		ctx2.register(ApplicationContextConfig.class);
		ctx2.register(ApplicationContextConfig2.class);
	}

	@Test
	public void testComponentScan() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.lejingw.apps.myspring3.annotation.conf");
		ctx.refresh();
		Assert.assertEquals("hello", ctx.getBean("message"));
	}
}
