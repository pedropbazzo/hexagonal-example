package com.rodolfoba.bookmark.application;

import static com.rodolfoba.bookmark.infra.persistence.jpa.JpaPersistenceUtil.createEntityManager;

import java.util.List;
import java.util.UUID;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;

import com.rodolfoba.bookmark.adapter.jpa.JpaBookmarkRepository;
import com.rodolfoba.bookmark.domain.Bookmark;
import com.rodolfoba.bookmark.domain.BookmarkService;
import com.rodolfoba.bookmark.infra.persistence.jpa.JpaTransactionalContext;

@Dependent
public class BookmarkApplication {

	private static BookmarkService createBookmarkService(EntityManager entityManager) {
		return new BookmarkService(new JpaBookmarkRepository(entityManager));
	}

	private static BookmarkUseCaseConfig createBookmarkUseCaseConfig(EntityManager entityManager) {
		BookmarkUseCaseConfig config = new BookmarkUseCaseConfig();
		config.transactionalContext = JpaTransactionalContext.create(entityManager);
		config.bookmarkService = createBookmarkService(entityManager);
		return config;
	}

	public List<Bookmark> findAll() {
		EntityManager em = createEntityManager();
		List<Bookmark> result = FindAllBookmarksUseCase.executa(createBookmarkUseCaseConfig(em));
		em.clear();
		em.close();
		return result;
	}

	public Bookmark load(UUID id) {
		EntityManager em = createEntityManager();
		Bookmark result = LoadBookmarkUseCase.executa(createBookmarkUseCaseConfig(em), id);
		em.clear();
		em.close();
		return result;
	}

	public UUID insert(InsertBookmarkCommand command) {
		EntityManager em = createEntityManager();
		UUID result = InsertBookmarkUseCase.executa(createBookmarkUseCaseConfig(em), command);
		em.clear();
		em.close();
		return result;
	}
	
	public void update(UpdateBookmarkCommand command) {
		EntityManager em = createEntityManager();
		UpdateBookmarkUseCase.executa(createBookmarkUseCaseConfig(em), command);
		em.clear();
		em.close();
	}
	
	public void delete(UUID id) {
		EntityManager em = createEntityManager();
		DeleteByIdUseCase.executa(createBookmarkUseCaseConfig(em), id);
		em.clear();
		em.close();
	}

}
