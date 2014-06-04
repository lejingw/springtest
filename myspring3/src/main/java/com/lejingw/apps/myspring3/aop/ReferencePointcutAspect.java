package com.lejingw.apps.myspring3.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ReferencePointcutAspect {
    
    @Pointcut(value="execution(* *(..))")
    public void pointcut() {}
    
}
