package com.lejingw.apps.myspring3.annotation.bean;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.lejingw.apps.myspring3.annotation.bean.qualifier.CustomQualifier;

public class TestBean35 {

	private DataSource DataSource;

	@Autowired
	public TestBean35(@CustomQualifier("oracleDataSource") DataSource dataSource) {
		this.DataSource = dataSource;
	}

	public DataSource getDataSource() {
		return DataSource;
	}
}
