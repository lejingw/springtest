package com.lejingw.apps.myspring3.aop.service;

public interface IHelloWorldService {

	public void sayHello(String param);

	public void sayBefore(String param);

	public boolean sayAfterReturning();

	public void sayAfterThrowing();

	public boolean sayAfterFinally();

	public void sayAround(String param);

	public void sayAdvisorBefore(String param);
}
