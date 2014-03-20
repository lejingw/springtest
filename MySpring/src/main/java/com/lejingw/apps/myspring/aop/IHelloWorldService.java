package com.lejingw.apps.myspring.aop;

public interface IHelloWorldService {
	public String sayHello();
	public String sayBefore(String abc);
	public void sayAfterThrowing(String a);
	public void sayAdvisorBefore(String a);
}