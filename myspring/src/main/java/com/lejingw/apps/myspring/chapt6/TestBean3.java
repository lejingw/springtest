package com.lejingw.apps.myspring.chapt6;

import org.springframework.beans.factory.annotation.Autowired;

public class TestBean3 {
	public String getMessage() {
		return message;
	}

	@Autowired
	// 字段注入
	private String message;
}