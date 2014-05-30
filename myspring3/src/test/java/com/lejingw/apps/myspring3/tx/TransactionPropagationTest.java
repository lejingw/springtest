package com.lejingw.apps.myspring3.tx;

import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.lejingw.apps.myspring3.tx.model.UserModel;

/**
 * 传播行为测试
 * @ClassName: TransactionPropagationTest
 * @Description: TODO
 * @author wanglj@hz.totyu.com
 * @date 2014年5月30日 下午2:44:33
 *
 */
public class TransactionPropagationTest extends TransactionPropagationBase {
	private static ApplicationContext ctx2 = null;
	private static JdbcTemplate jdbcTemplate2 = null;
	private static UserModel user = null;
	
	@BeforeClass
	public static void beforeClass(){
		String[] configLocations = new String[] {
				"classpath:com/lejingw/apps/myspring3/jdbc/template/applicationContext-resources.xml",
				"classpath:com/lejingw/apps/myspring3/tx/dao/applicationContext-jdbc.xml",
				"classpath:com/lejingw/apps/myspring3/tx/service/applicationContext-service.xml" };
		ctx2 = new ClassPathXmlApplicationContext(configLocations);

		jdbcTemplate2 = new JdbcTemplate(ctx2.getBean(DataSource.class));
		user = createDefaultUserModel();
	}
	
	// 1、Required传播行为
	@Test
	public void testRequired() {
		// Required传播行为，并成功执行
		prepareTable(jdbcTemplate2);
		requiredWithSuccess(ctx2, user);
		cleanTable(jdbcTemplate2);

		// Required传播行为，并抛出异常，将回滚事务
		prepareTable(jdbcTemplate2);
		requiredWithRuntimeException(ctx2, user);
		cleanTable(jdbcTemplate2);
	}
	

	// 2、RequiresNew传播行为
	@Test
	public void testRequiresNew() {
		// RequiresNew传播行为，并成功执行
		prepareTable(jdbcTemplate2);
		requiresNewWithSuccess(ctx2, user);
		cleanTable(jdbcTemplate2);

		// RequiresNew传播行为，并抛出异常，将回滚部分事务
		prepareTable(jdbcTemplate2);
		requiresNewWithRuntimeException(ctx2, user);
		cleanTable(jdbcTemplate2);
	}

	// 3、Supports传播行为
	@Test
	public void testSupports() {
		// Required+Supports传播行为，并成功执行
		prepareTable(jdbcTemplate2);
		requiredAndSupportsWithSuccess(ctx2, user);
		cleanTable(jdbcTemplate2);
	}
	@Test
	public void testSupports2() {
		// Required+Supports传播行为，并抛出异常，将回滚事务
		prepareTable(jdbcTemplate2);
		requiredAndSupportsWithRuntimeException(ctx2, user);
		cleanTable(jdbcTemplate2);
	}
	@Test
	public void testSupports3() {
		// Supports+Supports传播行为，并成功执行
		prepareTable(jdbcTemplate2);
		supportsAndSupportsWithSuccess(ctx2, user);
		cleanTable(jdbcTemplate2);
	}
	@Test
	public void testSupports4() {
		// Supports+Supports传播行为，并抛出异常，回滚事务对已执行的操作无影响
		prepareTable(jdbcTemplate2);
		supportsAndSupportsWithRuntimeException(ctx2, user);
		cleanTable(jdbcTemplate2);
	}

	// 4、NotSupported传播行为
	@Test
	public void testNotSupported() {
		// Required+Supports传播行为，并成功执行
		prepareTable(jdbcTemplate2);
		requiredAndNotSupportedWithSuccess(ctx2, user);
		cleanTable(jdbcTemplate2);
	}
	
	@Test
	public void testNotSupported2() {
		// Required+Supports传播行为，并抛出异常，将回滚部分事务
		prepareTable(jdbcTemplate2);
		requiredAndNotSupportedWithRuntimeException(ctx2, user);
		cleanTable(jdbcTemplate2);
	}
	
	@Test
	public void testNotSupported3() {
		// Supports+Supports传播行为，并成功执行
		prepareTable(jdbcTemplate2);
		supportsAndNotSupportedWithSuccess(ctx2, user);
		cleanTable(jdbcTemplate2);
	}
	
	@Test
	public void testNotSupported4() {
		// Supports+Supports传播行为，并抛出异常
		prepareTable(jdbcTemplate2);
		supportsAndNotSupportedWithRuntimeException(ctx2, user);
		cleanTable(jdbcTemplate2);
	}

	// 5、Mandatory传播行为
	@Test
	public void testMandatory() {
		// Required+Mandatory传播行为，并成功执行
		prepareTable(jdbcTemplate2);
		requiredAndMandatoryWithSuccess(ctx2, user);
		cleanTable(jdbcTemplate2);
	}
	@Test
	public void testMandatory2() {
		// Required+Mandatory传播行为，并抛出异常，将回滚事务
		prepareTable(jdbcTemplate2);
		requiredAndMandatoryWithRuntimeException(ctx2, user);
		cleanTable(jdbcTemplate2);
	}
	@Test
	public void testMandatory3() {
		// Supports+Mandatory传播行为，并抛出异常
		prepareTable(jdbcTemplate2);
		supportsAndMandatoryWithRuntimeException(ctx2, user);
		cleanTable(jdbcTemplate2);
	}

	// 6、Never传播行为
	@Test
	public void testNever() {
		// Required+Never传播行为，并抛出异常，将回滚部分事务
		prepareTable(jdbcTemplate2);
		requiredAndNeverWithRuntimeException(ctx2, user);
		cleanTable(jdbcTemplate2);
	}
	@Test
	public void testNever2() {
		// Supports+Never传播行为，并抛出异常
		prepareTable(jdbcTemplate2);
		supportsAndNeverWithSuccess(ctx2, user);
		cleanTable(jdbcTemplate2);
	}
	@Test
	public void testNever3() {
		// Supports+Never传播行为，并抛出异常,回滚事务对已执行的操作无影响
		prepareTable(jdbcTemplate2);
		supportsAndNeverWithRuntimeException(ctx2, user);
		cleanTable(jdbcTemplate2);
	}

	// 7、Nested传播行为
	@Test
	public void testNested() {
		// Required+Nested传播行为，成功执行
		prepareTable(jdbcTemplate2);
		requiredAndNestedWithSuccess(ctx2, user);
		cleanTable(jdbcTemplate2);
	}
	@Test
	public void testNested2() {
		// Required+Nested传播行为，并抛出异常，将回滚部分事务
		prepareTable(jdbcTemplate2);
		requiredAndNestedWithRuntimeException(ctx2, user);
		cleanTable(jdbcTemplate2);
	}
	@Test
	public void testNested3() {
		// Nested+Nested传播行为
		prepareTable(jdbcTemplate2);
		nestedAndNestedWithSuccess(ctx2, user);
		cleanTable(jdbcTemplate2);
	}
	@Test
	public void testNested4() {
		// Nested+Nested传播行为，并抛出异常,回滚事务对已执行的操作无影响
		prepareTable(jdbcTemplate2);
		nestedAndNestedWithRuntimeException(ctx2, user);
		cleanTable(jdbcTemplate2);
	}
	
}
