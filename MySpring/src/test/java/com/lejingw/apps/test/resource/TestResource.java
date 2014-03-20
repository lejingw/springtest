package com.lejingw.apps.test.resource;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.lejingw.apps.myspring.resource.ResourceBean;
import com.lejingw.apps.myspring.resource.ResourceBean2;

public class TestResource {
	@Test
	public void test() {
		ResourceLoader loader = new DefaultResourceLoader();
		
		Resource resource = loader.getResource("classpath:cn/javass/spring/chapter4/test1.txt");
		// 验证返回的是ClassPathResource
		Assert.assertEquals(ClassPathResource.class, resource.getClass());
		
		Resource resource2 = loader.getResource("file:cn/javass/spring/chapter4/test1.txt");
		// 验证返回的是ClassPathResource
		Assert.assertEquals(UrlResource.class, resource2.getClass());
		
		Resource resource3 = loader.getResource("cn/javass/spring/chapter4/test1.txt");
		// 验证返默认可以加载ClasspathResource
		Assert.assertTrue(resource3 instanceof ClassPathResource);
	}
	
	@Test  
	public void test2() {  
	    ApplicationContext ctx = new ClassPathXmlApplicationContext("resource/resourceLoaderAware.xml");  
	    ResourceBean resourceBean = ctx.getBean(ResourceBean.class);  
	    ResourceLoader loader = resourceBean.getResourceLoader();  
	    System.out.println("--:"+loader);
	    Assert.assertTrue(loader instanceof ApplicationContext);  
	}  
	
	@Test
	public void test3() {
	    ApplicationContext ctx = new ClassPathXmlApplicationContext("resource/resourceInject.xml");
	    ResourceBean2 resourceBean1 = ctx.getBean("resourceBean1", ResourceBean2.class);
	    ResourceBean2 resourceBean2 = ctx.getBean("resourceBean2", ResourceBean2.class);
	    Assert.assertTrue(resourceBean1.getResource() instanceof ClassPathResource);
	    Assert.assertTrue(resourceBean2.getResource() instanceof ClassPathResource);
	}
	
	@Test  
	public void testClasspathPrefix() throws IOException {  
	    ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();  
	    
	    //只加载一个绝对匹配Resource，且通过ResourceLoader.getResource进行加载  
	    Resource[] resources=resolver.getResources("classpath:META-INF/notice.txt");  
	    Assert.assertEquals(1, resources.length);  
	    
	    //只加载一个匹配的Resource，且通过ResourceLoader.getResource进行加载  
	    resources = resolver.getResources("classpath:META-INF/*.txt");
	    Assert.assertNotNull(resources);
	    Assert.assertTrue(resources.length == 0);             
	}  
	
	@Test  
	public void testClasspathAsteriskPrefix () throws IOException {  
	     ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();        
	     //将加载多个绝对匹配的所有Resource  
	    //将首先通过ClassLoader.getResources("META-INF")加载非模式路径部分  
	    //然后进行遍历模式匹配  
	    Resource[] resources=resolver.getResources("classpath*:META-INF/notice.txt");  
	    Assert.assertTrue(resources.length > 1);      
	    //将加载多个模式匹配的Resource  
	    resources = resolver.getResources("classpath*:META-INF/*.txt");  
	    Assert.assertTrue(resources.length > 1);    
	}  
}
