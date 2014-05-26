package com.lejingw.apps.myjpa.springdatajpa.service;


import java.util.List;

import org.springframework.data.domain.Pageable;

import com.lejingw.apps.myjpa.rawjpa.entity.AccountInfo;

/**
 * Author:ZhangJianPing Time:11-9-14,下午5:10
 */

public interface UserService {
	public AccountInfo createNewAccount(String username, String password,
			Integer initBalance);

	public AccountInfo findAccountInfoById(Long id);

	public List<AccountInfo> findByBalanceGreaterThan(Integer balance,
			Pageable pageable);
}
