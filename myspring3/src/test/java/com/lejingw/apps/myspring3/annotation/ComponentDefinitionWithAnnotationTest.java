package com.lejingw.apps.myspring3.annotation;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lejingw.apps.myspring3.annotation.bean.TestBean14;
import com.lejingw.apps.myspring3.annotation.bean.TestCompoment;
import com.lejingw.apps.myspring3.annotation.bean.TestManagedBean;
import com.lejingw.apps.myspring3.annotation.bean.TestNamedBean;
import com.lejingw.apps.myspring3.annotation.bean.action.TestAction;
import com.lejingw.apps.myspring3.annotation.bean.dao.TestHibernateDaoImpl;
import com.lejingw.apps.myspring3.annotation.bean.service.TestServiceImpl;
import com.lejingw.apps.myspring3.annotation.cache.TestCache;

public class ComponentDefinitionWithAnnotationTest {

	private static String configLocation = "classpath:com/lejingw/apps/myspring3/annotation/componentDefinitionWithAnnotation.xml";
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			configLocation);

	@Test
	public void testComponent() {
		TestCompoment component = ctx.getBean("component", TestCompoment.class);
		Assert.assertNotNull(component.getCtx());
	}

	@Test
	public void testDao() {
		TestHibernateDaoImpl dao = ctx.getBean("testHibernateDao",
				TestHibernateDaoImpl.class);
		Assert.assertNotNull(dao);
	}

	@Test
	public void testService() {
		TestServiceImpl service = ctx.getBean("testService",
				TestServiceImpl.class);
		Assert.assertNotNull(service.getDao());
	}

	@Test
	public void testWeb() {
		TestAction action = ctx.getBean("testAction", TestAction.class);
		Assert.assertNotNull(action);
	}

	@Test
	public void testCache() {
		//因为TestCache被自定义annotation Cache注释,而Cache被component注释，可以被spring scan到
		TestCache cache = ctx.getBean("cache", TestCache.class);
		Assert.assertNotNull(cache);
	}

	@Test
	public void testManagedBean() {
		TestManagedBean testManagedBean = ctx.getBean("managedBean",
				TestManagedBean.class);
		Assert.assertNotNull(testManagedBean.getCtx());
	}

	@Test
	public void testNamedBean() {
		TestNamedBean testNamedBean = ctx.getBean("namedBean",
				TestNamedBean.class);
		Assert.assertNotNull(testNamedBean.getCtx());
	}

	@Test
	public void testFilter() {
		TestBean14 testBean14 = ctx.getBean("testBean14", TestBean14.class);
		Assert.assertNotNull(testBean14);
	}

}
