package com.rodolfoba.bookmark.application;

import com.rodolfoba.bookmark.infra.TransactionalContext;

public abstract class AbstractBookmarkUseCase<T> {

	private TransactionalContext transactionalContext;
	
	public AbstractBookmarkUseCase(TransactionalContext transactionalContext) {
		this.transactionalContext = transactionalContext;
	}
	
	protected abstract T realiza();
	
	protected final TransactionalContext getTransactionalContext() {
		return transactionalContext;
	}
	
	protected final T aciona() {
		transactionalContext.begin();
		
		T result;
		try {
			result = realiza();
			transactionalContext.commit();
		} catch (Exception e) {
			transactionalContext.rollback();
			throw new RuntimeException(e);
		} 

		return result;
	}
}
