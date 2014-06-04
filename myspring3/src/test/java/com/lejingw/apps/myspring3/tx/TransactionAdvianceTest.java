package com.lejingw.apps.myspring3.tx;

import javax.sql.DataSource;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.IllegalTransactionStateException;

import com.lejingw.apps.myspring3.tx.model.UserModel;
import com.lejingw.apps.myspring3.tx.service.IAddressService;
import com.lejingw.apps.myspring3.tx.service.IUserService;

public class TransactionAdvianceTest extends TransactionPropagationBase{
	
	// 事务只读测试
	@Test
	public void testReadonlyTransaction() {
		String[] configLocations = new String[] {
				"classpath:com/lejingw/apps/myspring3/jdbc/template/applicationContext-resources.xml",
				"classpath:com/lejingw/apps/myspring3/tx/dao/applicationContext-jdbc.xml",
				"classpath:com/lejingw/apps/myspring3/tx/service/applicationContext-service.xml" };
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocations);
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ctx.getBean(DataSource.class));
		prepareTable(jdbcTemplate);

		IUserService userService = ctx.getBean("readonlyUserService", IUserService.class);

		ctx.getBean(DataSourceTransactionManager.class).setValidateExistingTransaction(true);
		try {
			userService.countAll();
			Assert.fail();
		} catch (RuntimeException e) {
			Assert.assertTrue(e instanceof IllegalTransactionStateException);
		}
		cleanTable(jdbcTemplate);
	}
	// 事务只读测试
	@Test
	public void testReadonlyTransaction2() {
		String[] configLocations = new String[] {
				"classpath:com/lejingw/apps/myspring3/jdbc/template/applicationContext-resources.xml",
				"classpath:com/lejingw/apps/myspring3/tx/dao/applicationContext-jdbc.xml",
				"classpath:com/lejingw/apps/myspring3/tx/service/applicationContext-service.xml" };
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocations);
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ctx.getBean(DataSource.class));
		prepareTable(jdbcTemplate);

		IUserService userService = ctx.getBean("readonlyUserService", IUserService.class);
		IAddressService addressService = ctx.getBean("readonlyAddressService", IAddressService.class);
		//设定了强制检查readonly（外部事务是否只读）和 隔离级别（是否一致，内部事务隔离级别为默认除外）
		ctx.getBean(DataSourceTransactionManager.class).setValidateExistingTransaction(true);
		
		//外部事务readonly为false，内部readonly为true，不会抛出异常（即使内部事务中有修改数据的行为发生）
		UserModel user = createDefaultUserModel();
		userService.save(user);
		//addressService.save(user.getAddress());
		
		try {
			//readonly为true，内部调用的addressService.countAll()的readonly为false
			//且设定了强制检查setValidateExistingTransaction(true)会抛出异常
			userService.countAll();
			Assert.fail();
		} catch (RuntimeException e) {
			Assert.assertTrue(e instanceof IllegalTransactionStateException);
		}
		Assert.assertEquals(1, addressService.countAll());
		
		cleanTable(jdbcTemplate);
	}
	
	// 配置实现事务控制测试
	@Test
	public void testConfigTransaction() {
		String[] configLocations = new String[] {
				"classpath:com/lejingw/apps/myspring3/jdbc/template/applicationContext-resources.xml",
				"classpath:com/lejingw/apps/myspring3/tx/dao/applicationContext-jdbc.xml",
				"classpath:com/lejingw/apps/myspring3/tx/service/applicationContext-service.xml" };
		ApplicationContext ctx2 = new ClassPathXmlApplicationContext( configLocations);

		DataSource dataSource2 = ctx2.getBean(DataSource.class);
		JdbcTemplate jdbcTemplate2 = new JdbcTemplate(dataSource2);
		jdbcTemplate2.update(CREATE_USER_TABLE_SQL);
		jdbcTemplate2.update(CREATE_ADDRESS_TABLE_SQL);

		IUserService userService = ctx2.getBean("proxyUserService", IUserService.class);
		IAddressService addressService = ctx2.getBean("proxyAddressService", IAddressService.class);
		
		UserModel user = createDefaultUserModel();

		userService.save(user);
		Assert.assertEquals(1, userService.countAll());
		Assert.assertEquals(1, addressService.countAll());

		jdbcTemplate2.update(DROP_USER_TABLE_SQL);
		jdbcTemplate2.update(DROP_ADDRESS_TABLE_SQL);
	}
	
	// 声明式实现事务控制测试
	@Test
	public void testDeclareTransaction() {
		String[] configLocations = new String[] {
				"classpath:com/lejingw/apps/myspring3/jdbc/template/applicationContext-resources.xml",
				"classpath:com/lejingw/apps/myspring3/tx/dao/applicationContext-jdbc.xml",
				"classpath:com/lejingw/apps/myspring3/tx/service/applicationContext-service-declare.xml" };
		ApplicationContext ctx2 = new ClassPathXmlApplicationContext(
				configLocations);
		DataSource dataSource2 = ctx2.getBean(DataSource.class);
		JdbcTemplate jdbcTemplate2 = new JdbcTemplate(dataSource2);
		jdbcTemplate2.update(CREATE_USER_TABLE_SQL);
		jdbcTemplate2.update(CREATE_ADDRESS_TABLE_SQL);
		IUserService userService = ctx2.getBean("userService", IUserService.class);
		IAddressService addressService = ctx2.getBean("addressService", IAddressService.class);
		UserModel user = createDefaultUserModel();
		userService.save(user);
		Assert.assertEquals(1, userService.countAll());
		Assert.assertEquals(1, addressService.countAll());

		jdbcTemplate2.update(DROP_USER_TABLE_SQL);
		jdbcTemplate2.update(DROP_ADDRESS_TABLE_SQL);
	}
	
	// 声明注解方式实现事务控制测试
	@Test
	public void testAnntationTransaction() {
		String[] configLocations = new String[] {
				"classpath:com/lejingw/apps/myspring3/jdbc/template/applicationContext-resources.xml",
				"classpath:com/lejingw/apps/myspring3/tx/dao/applicationContext-jdbc.xml",
				"classpath:com/lejingw/apps/myspring3/tx/service/applicationContext-service-annotation.xml" };
		ApplicationContext ctx2 = new ClassPathXmlApplicationContext(
				configLocations);
		DataSource dataSource2 = ctx2.getBean(DataSource.class);
		JdbcTemplate jdbcTemplate2 = new JdbcTemplate(dataSource2);
		jdbcTemplate2.update(CREATE_USER_TABLE_SQL);
		jdbcTemplate2.update(CREATE_ADDRESS_TABLE_SQL);
		
		IUserService userService = ctx2.getBean("userService", IUserService.class);
		IAddressService addressService = ctx2.getBean("addressService", IAddressService.class);
		UserModel user = createDefaultUserModel();
		try {
			userService.save(user);
			Assert.fail();
		} catch (RuntimeException e) {
		}
		Assert.assertEquals(0, userService.countAll());
		Assert.assertEquals(0, addressService.countAll());

		jdbcTemplate2.update(DROP_USER_TABLE_SQL);
		jdbcTemplate2.update(DROP_ADDRESS_TABLE_SQL);
	}
}
