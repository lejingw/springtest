package com.lejingw.apps.myspring3.tx.service;

import com.lejingw.apps.myspring3.tx.model.UserModel;

public interface IUserService {
    
    public void save(UserModel user);
    
    public int countAll();
}
