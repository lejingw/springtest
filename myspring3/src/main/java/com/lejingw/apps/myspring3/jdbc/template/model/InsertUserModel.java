package com.lejingw.apps.myspring3.jdbc.template.model;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class InsertUserModel extends SqlUpdate {

	public InsertUserModel(JdbcTemplate jdbcTemplate) {
		super.setJdbcTemplate(jdbcTemplate);
		super.setSql("insert into test(name) values(?)");
		super.declareParameter(new SqlParameter(Types.VARCHAR));
		compile();
	}
}
