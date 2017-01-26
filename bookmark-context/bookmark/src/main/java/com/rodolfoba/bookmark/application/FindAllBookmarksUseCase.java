package com.rodolfoba.bookmark.application;

import java.util.List;

import com.rodolfoba.bookmark.domain.Bookmark;
import com.rodolfoba.bookmark.domain.BookmarkService;

public class FindAllBookmarksUseCase extends AbstractBookmarkUseCase<List<Bookmark>> {

	private BookmarkService bookmarkService;
	
	private FindAllBookmarksUseCase(BookmarkUseCaseConfig config) {
		super(config.transactionalContext);
		this.bookmarkService = config.bookmarkService;
	}

	@Override
	protected List<Bookmark> realiza() {
		return bookmarkService.findAll();
	}
	
	public static List<Bookmark> executa(BookmarkUseCaseConfig config) {
		return new FindAllBookmarksUseCase(config).aciona();
	}
}
