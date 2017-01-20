package com.rodolfoba.bookmark.application;

import java.util.UUID;

import javax.persistence.EntityManager;

import com.rodolfoba.bookmark.domain.BookmarkService;

public class DeleteByIdUseCase extends AbstractBookmarkUseCase<Void> {

    private BookmarkService bookmarkService;
    private UUID id;

	public DeleteByIdUseCase(BookmarkService bookmarkService, EntityManager entityManager, UUID id) {
	    super(entityManager);
	    this.id = id;
	}

	@Override
	protected Void executa() {
		bookmarkService.deleteById(id);
		return null;
	}
}