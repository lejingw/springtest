package com.lejingw.apps.myjpa.rawjpa.service;

import com.lejingw.apps.myjpa.rawjpa.entity.AccountInfo;

/**
 * Author:ZhangJianPing Time:11-9-14,下午5:10
 */

public interface UserService {
	public AccountInfo createNewAccount(String username, String password,
			Integer initBalance);
}
