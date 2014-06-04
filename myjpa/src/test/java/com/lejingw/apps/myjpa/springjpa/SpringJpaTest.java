package com.lejingw.apps.myjpa.springjpa;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lejingw.apps.myjpa.springjpa.service.UserService;


public class SpringJpaTest {
	@Test
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/lejingw/apps/myjpa/springjpa/springjpa.xml");
		UserService userService = ctx.getBean("userService", UserService.class);
		userService.createNewAccount("w23e", "111111", 101);
	}

}
