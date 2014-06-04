package com.lejingw.apps.myspring3.orm.ibatis.dao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lejingw.apps.myspring3.jdbc.template.dao.IUserDao;
import com.lejingw.apps.myspring3.jdbc.template.model.UserModel;

public class UserIbatisDaoImpl extends SqlMapClientDaoSupport implements IUserDao {

    @Override
    public void save(UserModel model) {
        getSqlMapClientTemplate().insert("UserSQL.insert", model);
    }

    @Override
    public int countAll() {
        return (Integer) getSqlMapClientTemplate().queryForObject("UserSQL.countAll");
    }

}
