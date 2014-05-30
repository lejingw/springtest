package com.lejingw.apps.myspring3.tx.dao;

import com.lejingw.apps.myspring3.tx.model.AddressModel;


public interface IAddressDao {
    
    public void save(AddressModel address);

    public int countAll();
}
