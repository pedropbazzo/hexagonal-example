package com.rodolfoba.bookmark.infra.persistence.jpa;

import java.io.Serializable;

import javax.persistence.EntityManager;

public abstract class GenericJpaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager entityManager;
	
	public GenericJpaRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	protected final EntityManager getEntityManager() {
		return entityManager;
	}

}
