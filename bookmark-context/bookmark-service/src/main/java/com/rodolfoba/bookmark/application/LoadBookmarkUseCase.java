package com.rodolfoba.bookmark.application;

import java.util.UUID;

import javax.persistence.EntityManager;

import com.rodolfoba.bookmark.domain.Bookmark;
import com.rodolfoba.bookmark.domain.BookmarkService;

public class LoadBookmarkUseCase extends AbstractBookmarkUseCase<Bookmark> {

    private BookmarkService bookmarkService;
    private UUID id;

    LoadBookmarkUseCase(BookmarkService bookmarkService, EntityManager entityManager, UUID id) {
        super(entityManager);
        this.id = id;
    }

    @Override
    protected Bookmark executa() {
        return bookmarkService.load(id);
    }
}
