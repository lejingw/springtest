package com.lejingw.apps.myspring3.orm.ibatis;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ibatis.sqlmap.client.SqlMapSession;
import com.lejingw.apps.myspring3.jdbc.template.dao.IUserDao;
import com.lejingw.apps.myspring3.jdbc.template.model.UserModel;
import com.lejingw.apps.myspring3.orm.mybatis.dao.IUserDao2;

public class IbatisTest {

	private static SqlMapClient sqlMapClient;

	@BeforeClass
	public static void setUpClass() {
		String[] configLocations = new String[] {
				"classpath:com/lejingw/apps/myspring3/jdbc/template/applicationContext-resources.xml",
				"classpath:com/lejingw/apps/myspring3/orm/ibatis/applicationContext-ibatis.xml" };
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				configLocations);
		sqlMapClient = ctx.getBean(SqlMapClient.class);
	}

	@Before
	public void setUp() throws SQLException {
		sqlMapClient.update("UserSQL.createTable");
	}

	@After
	public void after() throws SQLException {
		sqlMapClient.update("UserSQL.dropTable");
	}

	@Test
	public void testFirst() throws SQLException {
		UserModel model = new UserModel();
		model.setMyName("test");
		SqlMapSession session = null;

		try {
			session = sqlMapClient.openSession();
			session.startTransaction();
			session.insert("UserSQL.insert", model);
			session.commitTransaction();
		} catch (SQLException e) {
			if (session != null) {
				session.endTransaction();
			}
			throw e;
		} finally {
			session.close();
		}
	}

	@Test
	public void testSqlMapClientTemplate() {
		SqlMapClientTemplate sqlMapClientTemplate = new SqlMapClientTemplate(sqlMapClient);
		final UserModel model = new UserModel();
		model.setMyName("myName");
		sqlMapClientTemplate.insert("UserSQL.insert", model);
		// hsqldb自增时，第一个是0
		Assert.assertEquals(0, model.getId());
		// 通过回调允许更复杂操作
		sqlMapClientTemplate.execute(new SqlMapClientCallback<Void>() {
			@Override
			public Void doInSqlMapClient(SqlMapExecutor session)
					throws SQLException {
				session.insert("UserSQL.insert", model);
				return null;
			}
		});
		// hsqldb自增时，第二个自然就是1
		Assert.assertEquals(1, model.getId());
	}

	@Test
	public void testBestPractice() {
		String[] configLocations = new String[] {
				"classpath:com/lejingw/apps/myspring3/jdbc/template/applicationContext-resources.xml",
				"classpath:com/lejingw/apps/myspring3/orm/ibatis/applicationContext-ibatis.xml" };
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				configLocations);
		IUserDao userDao = ctx.getBean(IUserDao.class);
		UserModel model = new UserModel();
		model.setMyName("test");
		userDao.save(model);
		Assert.assertEquals(1, userDao.countAll());
	}

	@Test
	public void testMybatisBestPractice() {
		String[] configLocations = new String[] {
				"classpath:com/lejingw/apps/myspring3/jdbc/template/applicationContext-resources.xml",
				"classpath:com/lejingw/apps/myspring3/orm/mybatis/applicationContext-mybatis.xml" };
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				configLocations);
		IUserDao userDao = ctx.getBean(IUserDao.class);
		UserModel model = new UserModel();
		model.setMyName("test");
		userDao.save(model);
		Assert.assertEquals(1, userDao.countAll());
	}

	@Test
	public void testMybatis2() {
		String[] configLocations = new String[] {
				"classpath:com/lejingw/apps/myspring3/jdbc/template/applicationContext-resources.xml",
				"classpath:com/lejingw/apps/myspring3/orm/mybatis/applicationContext-mybatis.xml" };
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				configLocations);
		IUserDao2 userDao = ctx.getBean(IUserDao2.class);
		UserModel model = new UserModel();
		model.setMyName("test");
		userDao.save(model);
		Assert.assertEquals(1, userDao.countAll());
	}

	@Test
	public void testSqlSessionTemplate() {
		String[] configLocations = new String[] {
				"classpath:com/lejingw/apps/myspring3/jdbc/template/applicationContext-resources.xml",
				"classpath:com/lejingw/apps/myspring3/orm/mybatis/applicationContext-mybatis.xml" };
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				configLocations);
		SqlSessionTemplate sqlSessionTemplate = ctx.getBean(SqlSessionTemplate.class);
		
		UserModel model = new UserModel();
		model.setMyName("test");
		sqlSessionTemplate.insert("UserSQL.insert", model);
		Assert.assertEquals(1, sqlSessionTemplate.selectOne("UserSQL.countAll"));
	}
}
