package com.lejingw.apps.myspring3.aop.aspect;

import org.springframework.stereotype.Component;

@Component("myComponent")
public class MyComponent {
	public Object returnObject() {
		System.out.println("call returnObject()");
		return new Object();
	}

	public Object returnRetVal() {
		System.out.println("call returnRetVal()");
		return new MyObject();
	}

	public void returnVoid() {
		System.out.println("call voidmethod()");
	}

	public void throwMyException() {
		throw new MyException("[error comming]");
	}
}