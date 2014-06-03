package com.lejingw.apps.myspring3.annotation.bean;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.lejingw.apps.myspring3.annotation.bean.qualifier.DataBase;
import com.lejingw.apps.myspring3.annotation.bean.qualifier.DataSourceType;

public class TestBean34 {
    
    private DataSource mysqlDataSource;
    private DataSource oracleDataSource;
    
    @Autowired
    public void initDataSource(
            @DataSourceType
            DataSource mysqlDataSource,
            @DataSourceType(ip="localhost", database=DataBase.ORACLE) 
            DataSource oracleDataSource) {
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
