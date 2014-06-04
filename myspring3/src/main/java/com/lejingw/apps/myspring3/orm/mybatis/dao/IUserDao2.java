package com.lejingw.apps.myspring3.orm.mybatis.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.lejingw.apps.myspring3.jdbc.template.model.UserModel;


public interface IUserDao2 {
    
    @Insert(value = "insert into test(name) values('${myName}')")
    @SelectKey(statement = "call identity()", keyProperty = "id",
               before = false, resultType = int.class)
    public void save(UserModel model);
    
    @Select(value = "select count(*) from test")
    public int countAll();
}
