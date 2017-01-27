package com.rodolfoba.bookmark.infra.persistence.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaPersistenceUtil {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookmark-ds");
	
	public static EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
	
	public static void destroyEntityManager(EntityManager entityManager) {
		entityManager.clear();
		entityManager.close();
	}
}
