package com.lejingw.apps.myspring3.tx.service.impl;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.lejingw.apps.myspring3.tx.dao.IUserDao;
import com.lejingw.apps.myspring3.tx.model.UserModel;
import com.lejingw.apps.myspring3.tx.service.IAddressService;
import com.lejingw.apps.myspring3.tx.service.IUserService;
import com.lejingw.apps.myspring3.tx.util.TransactionTemplateUtils;

public class ReadOnlyUserServiceImpl implements IUserService {

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
		TransactionTemplate transactionTemplate = TransactionTemplateUtils.getDefaultTransactionTemplate(txManager);
		transactionTemplate.setReadOnly(false);
		
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				userDao.save(user);
				user.getAddress().setUserId(user.getId());
				addressService.save(user.getAddress());
			}
		});

	}

	@Override
	public int countAll() {
		TransactionTemplate transactionTemplate = TransactionTemplateUtils.getDefaultTransactionTemplate(txManager);
		transactionTemplate.setReadOnly(true);
		
		return transactionTemplate.execute(new TransactionCallback<Integer>() {
			@Override
			public Integer doInTransaction(TransactionStatus status) {
				// 调用addressService的countAll方法，如果该方法事务不是readonly，将抛出异常
				addressService.countAll();
				return userDao.countAll();
			}
		});

	}

}
