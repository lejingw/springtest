package com.lejingw.apps.myspring3.jdbc.template.dao;

import com.lejingw.apps.myspring3.jdbc.template.model.UserModel;


public interface IUserDao {
    
    public void save(UserModel model);

    public int countAll();
}
