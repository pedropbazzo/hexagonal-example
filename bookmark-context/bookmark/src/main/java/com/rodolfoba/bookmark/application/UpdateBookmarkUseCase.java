package com.rodolfoba.bookmark.application;

import com.rodolfoba.bookmark.domain.Bookmark;
import com.rodolfoba.bookmark.domain.BookmarkService;

public class UpdateBookmarkUseCase extends AbstractBookmarkUseCase<Void> {

    private BookmarkService bookmarkService;
    private UpdateBookmarkCommand command;

    private UpdateBookmarkUseCase(BookmarkUseCaseConfig config, UpdateBookmarkCommand command) {
        super(config.transactionalContext);
        this.bookmarkService = config.bookmarkService;
        this.command = command;
    }

    @Override
    protected Void realiza() {
        Bookmark bookmark = new Bookmark(command.id, command.description, command.link);
        bookmarkService.update(bookmark);
        return null;
    }
    
    public static void executa(BookmarkUseCaseConfig config, UpdateBookmarkCommand command) {
		new UpdateBookmarkUseCase(config,  command).aciona();
	}
}