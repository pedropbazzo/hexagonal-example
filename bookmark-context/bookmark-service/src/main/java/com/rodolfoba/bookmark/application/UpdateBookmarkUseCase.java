package com.rodolfoba.bookmark.application;

import javax.persistence.EntityManager;

import com.rodolfoba.bookmark.domain.Bookmark;
import com.rodolfoba.bookmark.domain.BookmarkService;

public class UpdateBookmarkUseCase extends AbstractBookmarkUseCase<Void> {

    private BookmarkService bookmarkService;
    private UpdateBookmarkCommand command;

    public UpdateBookmarkUseCase(BookmarkService bookmarkService, EntityManager entityManager, UpdateBookmarkCommand command) {
        super(entityManager);
        this.bookmarkService = bookmarkService;
        this.command = command;
    }

    @Override
    protected Void executa() {
        Bookmark bookmark = new Bookmark(command.id, command.description, command.link);
        bookmarkService.update(bookmark);
        return null;
    }
}