package com.lejingw.apps.test.spel;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.lejingw.apps.myspring.spel.SpELBean;

public class SpELTest {
	@Test
	public void helloWorld() {
		ExpressionParser parser = new SpelExpressionParser();
		
		Expression expression = parser.parseExpression("('Hello' + ' World').concat(#end)");

		EvaluationContext context = new StandardEvaluationContext();
		context.setVariable("end", "!");
		
		Assert.assertEquals("Hello World!", expression.getValue(context));
	}

	@Test
	public void testParserContext() {
		ExpressionParser parser = new SpelExpressionParser();
		ParserContext parserContext = new ParserContext() {
			@Override
			public boolean isTemplate() {
				return true;
			}
			@Override
			public String getExpressionPrefix() {
				return "##{";
			}
			@Override
			public String getExpressionSuffix() {
				return "}";
			}
		};
		String template = "##{'Hello '}##{'World!'}";
		Expression expression = parser.parseExpression(template, parserContext);
		Assert.assertEquals("Hello World!", expression.getValue());
	}
	
	@Test  
	public void testXmlExpression() {  
	    ApplicationContext ctx = new ClassPathXmlApplicationContext("spel/spel.xml");  
	    String hello1 = ctx.getBean("hello1", String.class);  
	    String hello2 = ctx.getBean("hello2", String.class);  
	    String hello3 = ctx.getBean("hello3", String.class);  
	    Assert.assertEquals("Hello World!", hello1);  
	    Assert.assertEquals("Hello World!", hello2);  
	    Assert.assertEquals("Hello World!", hello3);  
	}  
	
	@Test  
	public void testAnnotationExpression() {  
	    ApplicationContext ctx = new ClassPathXmlApplicationContext("spel/spel.xml");  
	    SpELBean helloBean1 = ctx.getBean("helloBean1", SpELBean.class);  
	    Assert.assertEquals("Hello World!", helloBean1.getValue());  
	    SpELBean helloBean2 = ctx.getBean("helloBean2", SpELBean.class);  
	    Assert.assertEquals("haha", helloBean2.getValue());  
	} 
}