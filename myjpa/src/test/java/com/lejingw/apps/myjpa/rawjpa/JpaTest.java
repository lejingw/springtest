package com.lejingw.apps.myjpa.rawjpa;

import org.junit.Test;

import com.lejingw.apps.myjpa.rawjpa.service.UserServiceImpl;

/**
 * Author:ZhangJianPing Time:11-9-4,下午8:57
 */
public class JpaTest {
	@Test
	public void test1(){
		new UserServiceImpl().createNewAccount("qwe", "123456", 2);
	}
}
