package com.lejingw.apps.myspring3.aop.service.impl;

import com.lejingw.apps.myspring3.aop.service.IHelloWorldService;

public class HelloWorldService implements IHelloWorldService {
    
    @Override
    public void sayHello(String param) {
        System.out.println("============Hello " + param + "!");
    }
    

    @Override
    public void sayBefore(String param) {
        System.out.println("============say " + param);
    }

    @Override
    public boolean sayAfterReturning() {
        System.out.println("============after returning");
        return true;
    }

    @Override
    public void sayAfterThrowing() {
        System.out.println("============before throwing");
        throw new RuntimeException();
    }

    @Override
    public boolean sayAfterFinally() {
        System.out.println("============before finally");
        throw new RuntimeException();
    }

    @Override
    public void sayAround(String param) {
        System.out.println("============around param:" + param);
    }
   
    @Override
    public void sayAdvisorBefore(String param) {
        System.out.println("============say " + param);
    }
}
