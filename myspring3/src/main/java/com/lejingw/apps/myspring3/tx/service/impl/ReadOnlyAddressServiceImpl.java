package com.lejingw.apps.myspring3.tx.service.impl;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.lejingw.apps.myspring3.tx.dao.IAddressDao;
import com.lejingw.apps.myspring3.tx.model.AddressModel;
import com.lejingw.apps.myspring3.tx.service.IAddressService;
import com.lejingw.apps.myspring3.tx.util.TransactionTemplateUtils;

public class ReadOnlyAddressServiceImpl implements IAddressService {

	private IAddressDao addressDao;

	private PlatformTransactionManager txManager;

	public void setAddressDao(IAddressDao addressDao) {
		this.addressDao = addressDao;
	}

	public void setTxManager(PlatformTransactionManager txManager) {
		this.txManager = txManager;
	}

	@Override
	public void save(final AddressModel address) {
		TransactionTemplate transactionTemplate = TransactionTemplateUtils.getDefaultTransactionTemplate(txManager);
		transactionTemplate.setReadOnly(true);//外部事务readonly为false，不会抛出异常（即使内部事务中有修改数据的行为发生）
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				addressDao.save(address);
			}
		});
	}

	@Override
	public int countAll() {
		TransactionTemplate transactionTemplate = TransactionTemplateUtils.getDefaultTransactionTemplate(txManager);
		transactionTemplate.setReadOnly(false);
		
		return transactionTemplate.execute(new TransactionCallback<Integer>() {
			@Override
			public Integer doInTransaction(TransactionStatus status) {
				return addressDao.countAll();
			}
		});
	}

}
