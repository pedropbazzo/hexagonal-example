package com.rodolfoba.bookmark.application;

import com.rodolfoba.bookmark.domain.BookmarkService;
import com.rodolfoba.bookmark.infra.TransactionalContext;

public class BookmarkUseCaseConfig {

	public TransactionalContext transactionalContext;
	public BookmarkService bookmarkService;
	
}
