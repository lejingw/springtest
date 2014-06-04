package com.lejingw.apps.myspring3.orm.mybatis.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lejingw.apps.myspring3.jdbc.template.dao.IUserDao;
import com.lejingw.apps.myspring3.jdbc.template.model.UserModel;

public class UserMybatisDaoImpl extends SqlSessionDaoSupport implements IUserDao {

    @Override
    public void save(UserModel model) {
        getSqlSession().insert("UserSQL.insert", model);
    }

    @Override
    public int countAll() {
        return (Integer) getSqlSession().selectOne("UserSQL.countAll");
    }

}
