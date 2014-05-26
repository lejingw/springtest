package com.lejingw.apps.myjpa.springjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lejingw.apps.myjpa.rawjpa.entity.AccountInfo;
import com.lejingw.apps.myjpa.rawjpa.entity.UserInfo;
import com.lejingw.apps.myjpa.springjpa.dao.UserDao;

/**
 * Author:ZhangJianPing Time:11-9-14,下午5:10
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	public Long createNewAccount(String username, String password,
			Integer initBalance) {
		AccountInfo accountInfo = new AccountInfo();

		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(username);
		userInfo.setPassword(password);

		accountInfo.setBalance(initBalance);
		accountInfo.setUserInfo(userInfo);

		return userDao.save(accountInfo);
	}
}
