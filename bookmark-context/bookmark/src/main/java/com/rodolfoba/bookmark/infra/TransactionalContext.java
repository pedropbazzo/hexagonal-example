package com.rodolfoba.bookmark.infra;

public interface TransactionalContext {

	void begin();
	void commit();
	void rollback();
}
