package com.lejingw.apps.myspring.aop;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcut {
    @Pointcut(value = "execution(* com.lejingw.apps.myspring.aop.MethodTestBean.*(..))")
    public void methodTestPointcut() {}
}
