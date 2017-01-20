package com.rodolfoba.bookmark.application;

import java.util.List;

import javax.persistence.EntityManager;

import com.rodolfoba.bookmark.domain.Bookmark;
import com.rodolfoba.bookmark.domain.BookmarkService;

public class FindAllBookmarksUseCase extends AbstractBookmarkUseCase<List<Bookmark>> {

	private BookmarkService bookmarkService;
	
	FindAllBookmarksUseCase(BookmarkService bookmarkService, EntityManager entityManager) {
		super(entityManager);
		this.bookmarkService = bookmarkService;
	}

	@Override
	protected List<Bookmark> executa() {
		List<Bookmark> bookmarks = bookmarkService.findAll();
		return bookmarks;
	}
}
