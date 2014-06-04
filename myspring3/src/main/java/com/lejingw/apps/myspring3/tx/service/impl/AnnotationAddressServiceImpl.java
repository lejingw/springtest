package com.lejingw.apps.myspring3.tx.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lejingw.apps.myspring3.tx.dao.IAddressDao;
import com.lejingw.apps.myspring3.tx.model.AddressModel;
import com.lejingw.apps.myspring3.tx.service.IAddressService;

@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
public class AnnotationAddressServiceImpl implements IAddressService {
    
    private IAddressDao addressDao;
    

    public void setAddressDao(IAddressDao addressDao) {
        this.addressDao = addressDao;
    }
    
    @Override
    public void save(final AddressModel address) {
        addressDao.save(address);
        throw new RuntimeException();//将导致事务回滚
    }

    @Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, readOnly=true)
    @Override
    public int countAll() {
        return addressDao.countAll();
    }


}
