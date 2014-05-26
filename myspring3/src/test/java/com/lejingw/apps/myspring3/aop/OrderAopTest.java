package com.lejingw.apps.myspring3.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lejingw.apps.myspring3.aop.service.IPointcutService;

public class OrderAopTest {
    
    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lejingw/apps/myspring3/aop/order.xml");
        IPointcutService testService = ctx.getBean("pointcutService", IPointcutService.class);
        testService.test();
    }
}
