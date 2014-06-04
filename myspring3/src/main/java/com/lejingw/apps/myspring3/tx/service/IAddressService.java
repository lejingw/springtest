package com.lejingw.apps.myspring3.tx.service;

import com.lejingw.apps.myspring3.tx.model.AddressModel;

public interface IAddressService {
    
    public void save(AddressModel address);
    
    public int countAll();
}
