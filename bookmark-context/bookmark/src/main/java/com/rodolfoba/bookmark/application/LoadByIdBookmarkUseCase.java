package com.rodolfoba.bookmark.application;

import java.util.UUID;

import com.rodolfoba.bookmark.domain.Bookmark;
import com.rodolfoba.bookmark.domain.BookmarkService;

public class LoadByIdBookmarkUseCase extends AbstractBookmarkUseCase<Bookmark> {

	private BookmarkService bookmarkService;
	private UUID id;

	private LoadByIdBookmarkUseCase(BookmarkUseCaseConfig config, UUID id) {
		super(config.transactionalContext);
		this.bookmarkService = config.bookmarkService;
		this.id = id;
	}

	@Override
	protected Bookmark realiza() {
		return bookmarkService.load(id);
	}

	public static Bookmark executa(BookmarkUseCaseConfig config, UUID id) {
		return new LoadByIdBookmarkUseCase(config, id).aciona();
	}
}
