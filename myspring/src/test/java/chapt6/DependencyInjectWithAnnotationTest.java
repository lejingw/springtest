package chapt6;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lejingw.apps.myspring.chapt6.TestBean;
import com.lejingw.apps.myspring.chapt6.TestBean2;
import com.lejingw.apps.myspring.chapt6.TestBean3;

public class DependencyInjectWithAnnotationTest {

	private static String configLocation = "classpath:chapt6/dependecyInjectWithAnnotation.xml";
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);

	// 1、Spring自带依赖注入注解
	@Test
	public void testRequiredForXmlSetterInject() {
		TestBean testBean = ctx.getBean("testBean", TestBean.class);
		Assert.assertEquals("hello", testBean.getMessage());
	}

	@Test
	public void testAutowiredForConstructor() {
		TestBean2 testBean2 = ctx.getBean("testBean2", TestBean2.class);
		Assert.assertEquals("hello", testBean2.getMessage());
	}

	@Test
	public void testAutowiredForField() {
		TestBean3 testBean3 = ctx.getBean("testBean3", TestBean3.class);
		Assert.assertEquals("hello", testBean3.getMessage());
	}
}
