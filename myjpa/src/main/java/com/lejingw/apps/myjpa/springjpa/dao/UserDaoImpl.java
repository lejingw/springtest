package com.lejingw.apps.myjpa.springjpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lejingw.apps.myjpa.rawjpa.entity.AccountInfo;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public Long save(AccountInfo accountInfo) {
		em.persist(accountInfo);
		return accountInfo.getAccountId();
	}
}