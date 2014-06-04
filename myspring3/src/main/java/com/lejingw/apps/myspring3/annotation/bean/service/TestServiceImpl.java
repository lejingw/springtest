package com.lejingw.apps.myspring3.annotation.bean.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lejingw.apps.myspring3.annotation.bean.dao.TestHibernateDaoImpl;

@Service("testService")
public class TestServiceImpl {
    
    @Autowired
    @Qualifier("testHibernateDao")
    private TestHibernateDaoImpl dao;
    
    public TestHibernateDaoImpl getDao() {
        return dao;
    }
}
