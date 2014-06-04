package com.lejingw.apps.myspring3.tx.service.impl.mandatory;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.lejingw.apps.myspring3.tx.dao.IAddressDao;
import com.lejingw.apps.myspring3.tx.model.AddressModel;
import com.lejingw.apps.myspring3.tx.service.IAddressService;
import com.lejingw.apps.myspring3.tx.util.TransactionTemplateUtils;

public class RequiredAndMandatoryAddressServiceImplWithRuntimeException
		implements IAddressService {

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
		TransactionTemplate transactionTemplate = TransactionTemplateUtils
				.getTransactionTemplate(txManager,
						TransactionDefinition.PROPAGATION_MANDATORY,
						TransactionDefinition.ISOLATION_READ_COMMITTED);
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				addressDao.save(address);
			}
		});
		// 抛出异常将导致整个事务回滚
		throw new RuntimeException();
	}

	@Override
	public int countAll() {
		return addressDao.countAll();
	}

}
