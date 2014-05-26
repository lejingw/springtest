package com.lejingw.apps.myjpa.rawjpa.service;

import com.lejingw.apps.myjpa.rawjpa.dao.UserDao;
import com.lejingw.apps.myjpa.rawjpa.dao.UserDaoImpl;
import com.lejingw.apps.myjpa.rawjpa.entity.AccountInfo;
import com.lejingw.apps.myjpa.rawjpa.entity.UserInfo;

/**
 * Author:ZhangJianPing  Time:11-9-14,下午5:10
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao= new UserDaoImpl();

    public AccountInfo createNewAccount(String username, String password, Integer initBalance) {
        AccountInfo accountInfo = new AccountInfo();

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(password);

        accountInfo.setBalance(initBalance);
        accountInfo.setUserInfo(userInfo);

        return userDao.save(accountInfo);
    }
}
