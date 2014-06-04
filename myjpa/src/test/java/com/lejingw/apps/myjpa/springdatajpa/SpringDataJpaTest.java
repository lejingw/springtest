package com.lejingw.apps.myjpa.springdatajpa;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lejingw.apps.myjpa.springdatajpa.service.UserService;

import org.springframework.data.domain.PageRequest;

/**
 * Author:ZhangJianPing Time:11-9-4,下午8:57
 */
public class SpringDataJpaTest {
	@Test
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/lejingw/apps/myjpa/springdatajpa/springdatajpa.xml");
		UserService userService = ctx.getBean("userService", UserService.class);
		userService.createNewAccount("h2h", "hhh", 101);
		System.out.println(userService.findByBalanceGreaterThan(100,
				new PageRequest(0, 5)));
	}
}
