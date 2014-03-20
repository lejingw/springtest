package com.lejingw.apps.myspring.aop.impl;

import org.springframework.stereotype.Controller;

@Controller
public class UserAction2 {
	public String sayBefore(String str){
		String result = "hello " + str;
		System.out.println(result);
		return result;
	}
	
	public String sayBefore2(String str, String str2){
		String result = "hello " + str + " " + str2;
		System.out.println(result);
		return result;
	}
}
