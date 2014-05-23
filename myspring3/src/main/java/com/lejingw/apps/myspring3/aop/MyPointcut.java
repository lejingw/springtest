package com.lejingw.apps.myspring3.aop;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcut {
    @Pointcut(value = "execution(* com.lejingw.apps.myspring3.aop.MethodTestBean.*(..))")
    public void methodTestPointcut() {}
}
