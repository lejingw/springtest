package com.lejingw.apps.myspring3.tx.dao;

import com.lejingw.apps.myspring3.tx.model.UserModel;

public interface IUserDao {
    
    public void save(UserModel user);
    
    public int countAll();
    
}
