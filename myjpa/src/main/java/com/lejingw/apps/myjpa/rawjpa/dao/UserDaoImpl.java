package com.lejingw.apps.myjpa.rawjpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lejingw.apps.myjpa.rawjpa.entity.AccountInfo;

public class UserDaoImpl implements UserDao {
	public AccountInfo save(AccountInfo accountInfo) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimplePU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(accountInfo);
		em.getTransaction().commit();
		emf.close();
		return accountInfo;
	}
}