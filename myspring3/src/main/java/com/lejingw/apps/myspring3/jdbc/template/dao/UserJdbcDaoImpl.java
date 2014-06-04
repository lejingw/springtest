package com.lejingw.apps.myspring3.jdbc.template.dao;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.lejingw.apps.myspring3.jdbc.template.model.UserModel;

public class UserJdbcDaoImpl extends JdbcDaoSupport implements IUserDao {

    private static final String INSERT_SQL = "insert into test(name) values(:myName)";
    private static final String COUNT_ALL_SQL = "select count(*) from test";
    
    
    @Override
    public void save(UserModel model) {
        getJdbcTemplate().update(INSERT_SQL, new BeanPropertySqlParameterSource(model));
    }

    @Override
    public int countAll() {
        return getJdbcTemplate().queryForInt(COUNT_ALL_SQL);
    }
    
    
}
