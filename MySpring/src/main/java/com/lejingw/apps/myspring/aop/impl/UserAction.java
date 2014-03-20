package com.lejingw.apps.myspring.aop.impl;

import org.springframework.stereotype.Controller;

/**
 * 
 * @author zxf 演示aop测试类
 */
@Controller
public class UserAction {
	
	public Object queryUsers(String a) {
		System.out.println("-------queryUsers:" + a);
		return "aaax";
	}
	
	public Object queryUsers2(String a) {
		System.out.println("-------queryUsers:" + a);
		throw new RuntimeException();
	}

}
