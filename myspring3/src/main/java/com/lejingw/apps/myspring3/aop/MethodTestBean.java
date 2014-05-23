package com.lejingw.apps.myspring3.aop;

import org.springframework.stereotype.Component;

@Component("methodTestBean")
public class MethodTestBean {
	public Object returnObject(){
		System.out.println("call returnObject()");
		return new Object();
	}
	public Object returnRetVal(){
		System.out.println("call returnRetVal()");
		return new RetVal();
	}
	
	public void returnVoid(){
		System.out.println("call voidmethod()");
	}
	

	public void throwDataAccessException(){
		throw new DataAccessException("error comming");
	}
}
