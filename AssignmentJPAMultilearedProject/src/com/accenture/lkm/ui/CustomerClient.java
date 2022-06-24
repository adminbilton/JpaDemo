package com.accenture.lkm.ui;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.accenture.lkm.entity.CustomerEntity;
import com.accenture.lkm.utility.MyFactory;

public class CustomerClient {

	public static void main(String[] args) {

		EntityManagerFactory factory = null;
		EntityManager manager = null;

		try {
			factory = MyFactory.getEntityManagerFactory("SecondJPAProject");
			manager = MyFactory.getEntityManager(factory);

			getAllCustomerDetails(manager, 1002);
//			System.out.println("---------------");
//			addCustomer(manager, 1004, "Mahesh", "Delhi", new Date(), 40000D);
//			getAllCustomerDetails(manager, 1004);
//			System.out.println("---------------");
//			updateCustomer(manager, 1004);
//			getAllCustomerDetails(manager, 1004);
//			System.out.println("---------------");
//			removeCustomer(manager, 1004);
//			getAllCustomerDetails(manager, 1004);

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			manager.close();
			factory.close();
		}
	}

	public static void getAllCustomerDetails(EntityManager em, int id) {
		// TODO Auto-generated method stub

		CustomerEntity entity = null;

		entity = em.find(CustomerEntity.class, id);
 
		if (entity == null)
			System.out.println("No record found for CustomerId: " + id);
		else
			System.out.println(entity.getClass());

	}

	public static void addCustomer(EntityManager em, Integer setId, String setName, String setAddress, Date setRegDate,
			Double setWalletBalance) {
		// TODO Auto-generated method stub

		CustomerEntity entity = new CustomerEntity();

		entity.setCustomerId(setId);
		entity.setCustomerName(setName);
		entity.setAddress(setAddress);
		entity.setRegDate(setRegDate);
		entity.setWalletBalance(setWalletBalance);

		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();

			em.persist(entity);

			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.getStackTrace();
		}
	}

	public static void updateCustomer(EntityManager em, Integer searchId) {
		// TODO Auto-generated method stub

		CustomerEntity entity = null;

		entity = em.find(CustomerEntity.class, searchId);

		if (entity == null) {
			System.out.println("No record found...");
			return;
		}

		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();

			entity.setAddress("Mumbai");
			entity.setRegDate(new Date());

			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.getStackTrace();
		}

	}

	public static void removeCustomer(EntityManager em, Integer searchId) {
		// TODO Auto-generated method stub

		CustomerEntity entity = null;

		entity = em.find(CustomerEntity.class, searchId);

		if (entity == null) {
			System.out.println("No record found...");
			return;
		}

		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();

			em.remove(entity);

			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.getStackTrace();
		}
	}
}
