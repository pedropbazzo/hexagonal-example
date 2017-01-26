package com.rodolfoba.bookmark.infra.persistence.jpa;

import javax.persistence.EntityManager;

import com.rodolfoba.bookmark.infra.TransactionalContext;

public class JpaTransactionalContext implements TransactionalContext {

	private final EntityManager entityManager;
	
	private JpaTransactionalContext(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public static JpaTransactionalContext create(EntityManager entityManager) {
		return new JpaTransactionalContext(entityManager);
	}
	
	@Override
	public void begin() {
		this.entityManager.getTransaction().begin();
	}

	@Override
	public void commit() {
		this.entityManager.getTransaction().commit();
	}

	@Override
	public void rollback() {
		this.entityManager.getTransaction().rollback();
	}
}
