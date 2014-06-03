package com.lejingw.apps.myspring3.annotation.bean;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.lejingw.apps.myspring3.annotation.bean.qualifier.Mysql;
import com.lejingw.apps.myspring3.annotation.bean.qualifier.Oracle;

public class TestBean33 {
    
    private DataSource mysqlDataSource;
    private DataSource oracleDataSource;
    
    @Autowired
    public void initDataSource(@Mysql DataSource mysqlDataSource, @Oracle DataSource oracleDataSource) {
        this.mysqlDataSource = mysqlDataSource;
        this.oracleDataSource = oracleDataSource;
    }
    
    public DataSource getMysqlDataSource() {
        return mysqlDataSource;
    }
    
    public DataSource getOracleDataSource() {
        return oracleDataSource;
    }
    
}
