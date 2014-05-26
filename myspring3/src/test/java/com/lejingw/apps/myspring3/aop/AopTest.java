package com.lejingw.apps.myspring3.aop;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lejingw.apps.myspring3.aop.service.IHelloWorldService;
import com.lejingw.apps.myspring3.aop.service.IIntroductionService;

public class AopTest {
    
    @Test
    public void testHelloworld() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lejingw/apps/myspring3/aop/helloworld.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayHello("world");
        Assert.assertTrue(AopUtils.isAopProxy(helloworldService));
    }
    
    @Test
    public void testSchemaBeforeAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lejingw/apps/myspring3/aop/advice.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayBefore("before");
        System.out.println("======================================");
    }

    @Test
    public void testSchemaAfterReturningAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lejingw/apps/myspring3/aop/advice2.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayAfterReturning();
        System.out.println("======================================");
    }

    @Test(expected = RuntimeException.class)
    public void testSchemaAfterThrowingAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lejingw/apps/myspring3/aop/advice.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayAfterThrowing();
        System.out.println("======================================");
    }
    @Test(expected = RuntimeException.class)
    public void testSchemaAfterFinallyAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lejingw/apps/myspring3/aop/advice.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayAfterFinally();
        System.out.println("======================================");
    }

    @Test
    public void testSchemaAroundAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lejingw/apps/myspring3/aop/advice.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayAround("haha");
        System.out.println("======================================");
    }

    @Test
    public void testSchemaIntroduction() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lejingw/apps/myspring3/aop/advice.xml");
        IIntroductionService introductionService = ctx.getBean("helloWorldService", IIntroductionService.class);
        introductionService.induct();
        System.out.println("======================================");
    }

    @Test
    public void testSchemaAdvisor() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lejingw/apps/myspring3/aop/advice.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayAdvisorBefore("haha");
        System.out.println("======================================");
    }
    
    @Test
    public void seperator() {
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
    
    @Test
    public void testAnnotationBeforeAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lejingw/apps/myspring3/aop/advice2.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayBefore("before");
        System.out.println("======================================");
    }
    
    @Test
    public void testAnnotationAfterReturningAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lejingw/apps/myspring3/aop/advice2.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayAfterReturning();
        System.out.println("======================================");
    }
    
    @Test(expected = RuntimeException.class)
    public void testAnnotationAfterThrowingAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lejingw/apps/myspring3/aop/advice2.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayAfterThrowing();
        System.out.println("======================================");
    }
    @Test(expected = RuntimeException.class)
    public void testAnnotationAfterFinallyAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lejingw/apps/myspring3/aop/advice2.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayAfterFinally();
        System.out.println("======================================");
    }
    
    @Test
    public void testAnnotationAroundAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lejingw/apps/myspring3/aop/advice2.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayAround("haha");
        System.out.println("======================================");
    }
    
    @Test
    public void testAnnotationIntroduction() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lejingw/apps/myspring3/aop/advice2.xml");
        IIntroductionService introductionService = ctx.getBean("helloWorldService", IIntroductionService.class);
        introductionService.induct();
        System.out.println("======================================");
    }
}
