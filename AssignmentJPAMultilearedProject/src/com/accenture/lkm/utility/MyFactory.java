package com.accenture.lkm.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.accenture.lkm.entity.CustomerEntity;

public class MyFactory {

	public static EntityManagerFactory getEntityManagerFactory(String unitName) {
		return Persistence.createEntityManagerFactory(unitName);
	}

	public static EntityManager getEntityManager(EntityManagerFactory factory) {
		return factory.createEntityManager();
	}

}
