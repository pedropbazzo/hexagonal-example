package com.rodolfoba.bookmark.application;

import java.util.UUID;

import com.rodolfoba.bookmark.domain.Bookmark;
import com.rodolfoba.bookmark.domain.BookmarkService;

public class InsertBookmarkUseCase extends AbstractBookmarkUseCase<UUID> {

	private BookmarkService bookmarkService;
    private InsertBookmarkCommand command;
	
	private InsertBookmarkUseCase(BookmarkUseCaseConfig config, InsertBookmarkCommand command) {
		super(config.transactionalContext);
		this.bookmarkService = config.bookmarkService;
	    this.command = command;
	}
	
	@Override
	protected UUID realiza() {
		Bookmark bookmark = new Bookmark(command.description, command.link);
		bookmarkService.insert(bookmark);
		return bookmark.getId();
	}
	
	public static UUID executa(BookmarkUseCaseConfig config, InsertBookmarkCommand command) {
		return new InsertBookmarkUseCase(config,  command).aciona();
	}
}