package com.lejingw.apps.myspring3.tx.service.impl.required;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.lejingw.apps.myspring3.tx.dao.IUserDao;
import com.lejingw.apps.myspring3.tx.model.UserModel;
import com.lejingw.apps.myspring3.tx.service.IAddressService;
import com.lejingw.apps.myspring3.tx.service.IUserService;
import com.lejingw.apps.myspring3.tx.util.TransactionTemplateUtils;

public class RequiredUserServiceImplWithRuntimeException implements
		IUserService {

	private IUserDao userDao;

	private IAddressService addressService;

	private PlatformTransactionManager txManager;

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public void setTxManager(PlatformTransactionManager txManager) {
		this.txManager = txManager;
	}

	public void setAddressService(IAddressService addressService) {
		this.addressService = addressService;
	}

	@Override
	public void save(final UserModel user) {
		TransactionTemplate transactionTemplate = TransactionTemplateUtils
				.getDefaultTransactionTemplate(txManager);
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				userDao.save(user);
				user.getAddress().setUserId(user.getId());
				try {
					// 如果该业务方法被标记为回滚，则不管是否捕获该异常都将发生回滚，因为处于同一逻辑事务
					addressService.save(user.getAddress());// 将在同一个事务内执行
				} catch (RuntimeException e) {
				}
			}
		});

	}

	@Override
	public int countAll() {
		return userDao.countAll();
	}

}
