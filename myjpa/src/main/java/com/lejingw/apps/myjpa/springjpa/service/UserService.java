package com.lejingw.apps.myjpa.springjpa.service;


/**
 * Author:ZhangJianPing Time:11-9-14,下午5:10
 */

public interface UserService {
	public Long createNewAccount(String username, String password,
			Integer initBalance);
}
