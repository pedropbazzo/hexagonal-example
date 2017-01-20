package com.rodolfoba.bookmark.application;

import javax.persistence.EntityManager;

public abstract class AbstractBookmarkUseCase<T> {

	private EntityManager entityManager;
	
	public AbstractBookmarkUseCase(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	protected abstract T executa();
	
	protected final EntityManager getEntityManager() {
		return entityManager;
	}
	
	public final T aciona() {
		entityManager.getTransaction().begin();
		
		T result;
		try {
			result = executa();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			entityManager.clear();
			entityManager.close();
		}

		return result;
	}
}
