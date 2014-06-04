package com.lejingw.apps.myspring3.orm.hibernate.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lejingw.apps.myspring3.jdbc.template.dao.IUserDao;
import com.lejingw.apps.myspring3.jdbc.template.model.UserModel;

public class UserHibernateDaoImpl extends HibernateDaoSupport implements IUserDao {

    private static final String COUNT_ALL_HQL = "select count(*) from UserModel";
    
    @Override
    public void save(UserModel model) {
        getHibernateTemplate().save(model);
    }

    @Override
    public int countAll() {
        Number count = (Number) getHibernateTemplate().find(COUNT_ALL_HQL).get(0);
        return count.intValue();
    }
    
}
