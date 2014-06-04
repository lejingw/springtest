package com.lejingw.apps.myspring3.aop.aspect.pointcut;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcut {
    @Pointcut(value = "execution(* com.lejingw.apps.myspring3.aop.aspect.MyComponent.*(..))")
    public void methodTestPointcut() {}
}
