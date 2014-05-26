package com.lejingw.apps.myspring3.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;

import com.lejingw.apps.myspring3.aop.service.IIntroductionService;
import com.lejingw.apps.myspring3.aop.service.impl.IntroductiondService;

@Aspect
public class PointcutAspect {
        
    /*1、execution*/
    
    @Before(value = "execution(public * *(..))")
    public void executionTest1(JoinPoint jp) {
        dump("execution(public * *(..)", jp);
    }

    @Before(value = "execution(* com.lejingw.apps.myspring3.aop..IPointcutService.*())")
    public void executionTest2(JoinPoint jp) {
        dump("execution(* com.lejingw.apps.myspring3.aop..IPointcutService.*())", jp);
    }
    
    @Before(value = "execution(* com.lejingw.apps.myspring3.aop..*.*(..))")
    public void executionTest3(JoinPoint jp) {
        dump("execution(* com.lejingw.apps.myspring3.aop..*.*(..))", jp);
    }

    @Before(value = "execution(* com.lejingw.apps.myspring3.aop..IPointcutService.*(*))")
    public void executionTest4(JoinPoint jp) {
        dump("execution(* com.lejingw.apps.myspring3.aop..IPointcutService.*(*))", jp);
    }   
    @Before(value = "execution(* (!com.lejingw.apps.myspring3.aop..IPointcutService+).*(..))")
    public void executionTest5(JoinPoint jp) {
        //如果!com.lejingw.apps.myspring3.aop..IPointcutService+ 不加“+”将匹配不到
        dump("execution(* (!com.lejingw.apps.myspring3.aop..IPointcutService+).*(..))", jp);
    }


    @Before(value = "execution(* com.lejingw.apps.myspring3.aop..IPointcutService+.*())")
    public void executionTest6(JoinPoint jp) {
        dump("execution(* com.lejingw.apps.myspring3.aop..IPointcutService+.*())", jp);
    }

    @Before(value = "execution(* com.lejingw.apps.myspring3.aop..IPointcut*.test*(java.util.Date))")
    public void executionTest7(JoinPoint jp) {
        dump("execution(* com.lejingw.apps.myspring3.aop..IPointcut*.test*(java.util.Date))", jp);
    }

    @Before(value = "execution(* com.lejingw.apps.myspring3.aop..IPointcut*.test*(..)  throws IllegalArgumentException, ArrayIndexOutOfBoundsException)")
    public void executionTest8(JoinPoint jp) {
        dump("execution(* com.lejingw.apps.myspring3.aop..IPointcut*.test*(..)  throws IllegalArgumentException, ArrayIndexOutOfBoundsException)", jp);
    }

    @Before(value = "execution(* (com.lejingw.apps.myspring3.aop..IPointcutService+ && java.io.Serializable+).*(..))")
    public void executionTest9(JoinPoint jp) {
        dump("execution(* (com.lejingw.apps.myspring3.aop..IPointcutService+ && java.io.Serializable+).*(..))", jp);
    }

    @Before(value = "execution(@java.lang.Deprecated * *(..))")
    public void executionTest10(JoinPoint jp) {
        dump("execution(@java.lang.Deprecated * *(..))", jp);
    }
    

    @Before(value = "execution(@java.lang.Deprecated @com.lejingw.apps.myspring3.aop..Secure * *(..))")
    public void executionTest11(JoinPoint jp) {
        dump("execution(@java.lang.Deprecated @com.lejingw.apps.myspring3.aop..Secure * *(..))", jp);
    }

    @Before(value = "execution(@(java.lang.Deprecated || com.lejingw.apps.myspring3.aop..Secure) * *(..))")
    public void executionTest12(JoinPoint jp) {
        dump("execution(@(java.lang.Deprecated || com.lejingw.apps.myspring3.aop..Secure) * *(..))", jp);
    }
    
    
    @Before(value = "execution((@com.lejingw.apps.myspring3.aop..Secure *)  *(..))")
    public void executionTest13(JoinPoint jp) {
        dump("execution((@com.lejingw.apps.myspring3.aop..Secure *)  *(..))", jp);
    }

    @Before(value = "execution(*  (@com.lejingw.apps.myspring3.aop..Secure *).*(..))")
    public void executionTest14(JoinPoint jp) {
        dump("execution(*  (@com.lejingw.apps.myspring3.aop..Secure *).*(..))", jp);
    }

    @Before(value = "execution(* *(@com.lejingw.apps.myspring3.aop..Secure (*) , @com.lejingw.apps.myspring3.aop..Secure (*)))")
    public void executionTest15(JoinPoint jp) {
        dump("execution(* *(@com.lejingw.apps.myspring3.aop..Secure (*) , @com.lejingw.apps.myspring3.aop..Secure (*)))", jp);
    }

    @Before(value = "execution(* *((@ com.lejingw.apps.myspring3.aop..Secure *)))")
    public void executionTest16_1(JoinPoint jp) {
        dump("execution(* *((@ com.lejingw.apps.myspring3.aop..Secure *)))", jp);
    }
    @Before(value = "execution(* *(@ com.lejingw.apps.myspring3.aop..Secure *))")
    public void executionTest16_2(JoinPoint jp) {
        dump("execution(* *(@ com.lejingw.apps.myspring3.aop..Secure *))", jp);
    }
    

    @Before(value = "execution(* *(@com.lejingw.apps.myspring3.aop..Secure (@com.lejingw.apps.myspring3.aop..Secure *), @com.lejingw.apps.myspring3.aop..Secure (@com.lejingw.apps.myspring3.aop..Secure *)))")
    public void executionTest17(JoinPoint jp) {
        dump("execution(* *(@com.lejingw.apps.myspring3.aop..Secure (@com.lejingw.apps.myspring3.aop..Secure *), @com.lejingw.apps.myspring3.aop..Secure (@com.lejingw.apps.myspring3.aop..Secure *)))", jp);
    }

    @Before(value = "execution(* *(java.util.Map<com.lejingw.apps.myspring3.aop..Model, com.lejingw.apps.myspring3.aop..Model>, ..))")
    public void executionTest18(JoinPoint jp) {
        dump("execution(* *(java.util.Map<com.lejingw.apps.myspring3.aop..Model, com.lejingw.apps.myspring3.aop..Model>, ..))", jp);
    }

    @Before(value = "execution(* *(java.util.HashMap<com.lejingw.apps.myspring3.aop..Model, com.lejingw.apps.myspring3.aop..Model>, ..))")
    public void executionTest18_1(JoinPoint jp) {
        dump("execution(* *(java.util.HashMap<com.lejingw.apps.myspring3.aop..Model, com.lejingw.apps.myspring3.aop..Model>, ..))", jp);
    }

    @Before(value = "execution(* *(java.util.Collection<@com.lejingw.apps.myspring3.aop..Secure *>))")
    public void executionTest19(JoinPoint jp) {
        dump("execution(* *(java.util.Collection<@com.lejingw.apps.myspring3.aop..Secure *>))", jp);
    }

    @Before(value = "execution(* *(java.util.Set<? extends java.util.HashMap>))")
    public void executionTest20(JoinPoint jp) {
        //不正常工作
        dump("execution(* *(java.util.Set<? extends java.util.HashMap>))", jp);
    }

    @Before(value = "execution(* *(java.util.Stack<? super java.util.HashMap>))")
    public void executionTest21(JoinPoint jp) {
        //不正常工作
        dump("execution(* *(java.util.Stack<? super java.util.HashMap>))", jp);
    }
    
    
    
    @Before(value = "execution(* *(*<@com.lejingw.apps.myspring3.aop..Secure *>))")
    public void executionTest22(JoinPoint jp) {
        //不正常工作
        dump("execution(* *(*<@com.lejingw.apps.myspring3.aop..Secure *>))", jp);
    }
    
    /*2、within*/

    @Before(value = "within(com.lejingw.apps.myspring3.aop..*)")
    public void withinTest1(JoinPoint jp) {
        dump("within(com.lejingw.apps.myspring3.aop..*)", jp);
    }

    @Before(value = "within(com.lejingw.apps.myspring3.aop..IPointcutService+) ")
    public void withinTest2(JoinPoint jp) {
        dump("within(com.lejingw.apps.myspring3.aop..IPointcutService+) ", jp);
    }

    @Before(value = "within(@com.lejingw.apps.myspring3.aop..Secure *)")
    public void withinTest3(JoinPoint jp) {
        dump("within(@com.lejingw.apps.myspring3.aop..Secure *)", jp);
    }
    

    @DeclareParents(value = "com.lejingw.apps.myspring3.aop..IPointcutService+", defaultImpl = IntroductiondService.class)
    private IIntroductionService introductionService;
    
    /*3、this*/
    @Before(value = "this(com.lejingw.apps.myspring3.aop.service.IPointcutService)")
    public void thisTest1(JoinPoint jp) {
        dump("this(com.lejingw.apps.myspring3.aop..IPointcutService)", jp);
    }
    
    @Before(value = "this(com.lejingw.apps.myspring3.aop.service.IIntroductionService)")
    public void thisTest2(JoinPoint jp) {
        dump("this(com.lejingw.apps.myspring3.aop..IIntroductionService)", jp);
    }
    
    /*4、target*/
    
    @Before(value = "target(com.lejingw.apps.myspring3.aop.service.IPointcutService)")
    public void targetTest1(JoinPoint jp) {
        dump("target(com.lejingw.apps.myspring3.aop..IPointcutService)", jp);
    }
    
    @Before(value = "target(com.lejingw.apps.myspring3.aop.service.IIntroductionService)")
    public void targetTest2(JoinPoint jp) {
        //注意与this(com.lejingw.apps.myspring3.aop.service.IIntroductionService)区别
        dump("target(com.lejingw.apps.myspring3.aop..IIntroductionService)", jp);
    }
    
    /*5、args*/
    @Before(value = "args(java.io.Serializable, ..)")
    public void argsTest1(JoinPoint jp) {
        dump("args(java.io.Serializable, ..)", jp);
    }
    
    /*6、@within*/
    @Before(value = "@within(com.lejingw.apps.myspring3.aop.Secure)")
    public void annotationWithinTest1(JoinPoint jp) {
        dump("@within(com.lejingw.apps.myspring3.aop.Secure)", jp);
    }
    /*7、@target*/
    @Before(value = "@target(com.lejingw.apps.myspring3.aop.Secure)")
    public void annotationTargetTest1(JoinPoint jp) {
        dump("@target(com.lejingw.apps.myspring3.aop.Secure)", jp);
    }
    /*8、@args*/
    @Before(value = "@args(com.lejingw.apps.myspring3.aop.Secure)")
    public void annotationArgsTest1(JoinPoint jp) {
        dump("@args(com.lejingw.apps.myspring3.aop.Secure)", jp);
    }
    /*9、@annotation*/
    @Before(value = "@annotation(com.lejingw.apps.myspring3.aop.Secure)")
    public void annotationAnnotationTest1(JoinPoint jp) {
        dump("@annotation(com.lejingw.apps.myspring3.aop.Secure)", jp);
    }
    /*10、bean*/
    @Before(value = "bean(*Service)")
    public void beanTest1(JoinPoint jp) {
        dump("bean(*Service)", jp);
    }
    /*11、reference pointcut*/
    
    @Pointcut(value="bean(*Service)")
    private void pointcut1(){}

    @Pointcut(value="@args(com.lejingw.apps.myspring3.aop.Secure)")
    private void pointcut2(){}
    
    @Before(value = "pointcut1() && pointcut2()")
    public void referencePointcutTest1(JoinPoint jp) {
        dump("pointcut1() && pointcut2()", jp);
    }
    
    
    @Before(value = "com.lejingw.apps.myspring3.aop.ReferencePointcutAspect.pointcut()")
    public void referencePointcutTest2(JoinPoint jp) {
        dump("com.lejingw.apps.myspring3.aop.ReferencePointcutAspect.pointcut()", jp);
    }
    
    
    
    private void dump(String expression, JoinPoint jp) {
        System.out.println("=============== [" + expression + "] matches [" + jp.getSignature().toLongString()+ "]");
    }
}