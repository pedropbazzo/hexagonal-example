package com.rodolfoba.bookmark.application;

import static com.rodolfoba.bookmark.infra.persistence.jpa.JpaPersistenceUtil.createEntityManager;

import java.util.UUID;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;

import com.rodolfoba.bookmark.adapter.jpa.BookmarkJpaRepository;
import com.rodolfoba.bookmark.domain.BookmarkService;

@Dependent
public class BookmarkUseCaseFactoryImpl implements BookmarkUseCaseFactory {

    private static BookmarkService createBookmarkService(EntityManager entityManager) {
        return new BookmarkService(new BookmarkJpaRepository(entityManager));
    }

    @Override
    public FindAllBookmarksUseCase createFindAllBookmarksUseCase() {
        EntityManager em = createEntityManager();
        BookmarkService bookmarkService = createBookmarkService(em);
        return new FindAllBookmarksUseCase(bookmarkService, em);
    }

    @Override
    public LoadBookmarkUseCase createLoadBookmarkUseCase(UUID id) {
        EntityManager em = createEntityManager();
        BookmarkService bookmarkService = createBookmarkService(em);
        return new LoadBookmarkUseCase(bookmarkService, em, id);
    }

    @Override
    public InsertBookmarkUseCase createInsertBookmarkUseCase(CreateBookmarkCommand command) {
        EntityManager em = createEntityManager();
        BookmarkService bookmarkService = createBookmarkService(em);
        return new InsertBookmarkUseCase(bookmarkService, em, command);
    }

    @Override
    public UpdateBookmarkUseCase createUpdateBookmarkUseCase(UpdateBookmarkCommand command) {
        EntityManager em = createEntityManager();
        BookmarkService bookmarkService = createBookmarkService(em);
        return new UpdateBookmarkUseCase(bookmarkService, em, command);
    }

    @Override
    public DeleteByIdUseCase createDeleteByIdUseCase(UUID id) {
        EntityManager em = createEntityManager();
        BookmarkService bookmarkService = createBookmarkService(em);
        return new DeleteByIdUseCase(bookmarkService, em, id);
    }
}