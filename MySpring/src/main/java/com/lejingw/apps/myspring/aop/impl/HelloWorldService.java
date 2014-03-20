package com.lejingw.apps.myspring.aop.impl;

import com.lejingw.apps.myspring.aop.IHelloWorldService;

public class HelloWorldService implements IHelloWorldService {
	
	@Override
	public String sayHello() {
		System.out.println("============Hello World!");
		return "sss";
	}

	public String sayBefore(String abc) {
		System.out.println("=========sayBefore========");
		return "abc";
	}

	@Override
	public void sayAfterThrowing(String b) {
		System.out.println("============before throwing:" + b);
		throw new RuntimeException();
	}

	@Override
	public void sayAdvisorBefore(String param) {
		System.out.println("============say " + param);
	}
}