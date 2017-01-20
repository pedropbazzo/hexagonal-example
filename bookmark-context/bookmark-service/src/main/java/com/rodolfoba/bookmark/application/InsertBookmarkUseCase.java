package com.rodolfoba.bookmark.application;

import java.util.UUID;

import javax.persistence.EntityManager;

import com.rodolfoba.bookmark.domain.Bookmark;
import com.rodolfoba.bookmark.domain.BookmarkService;

public class InsertBookmarkUseCase extends AbstractBookmarkUseCase<UUID> {

    private BookmarkService bookmarkService;
    private CreateBookmarkCommand command;
	
	InsertBookmarkUseCase(BookmarkService bookmarkService, EntityManager entityManager, CreateBookmarkCommand command) {
		super(entityManager);
		this.bookmarkService = bookmarkService;
	    this.command = command;
	}
	
	@Override
	protected UUID executa() {
		Bookmark bookmark = new Bookmark(command.description, command.link);
		bookmarkService.insert(bookmark);
		return bookmark.getId();
	}
}