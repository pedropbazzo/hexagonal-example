package com.rodolfoba.bookmark.application;

import java.util.UUID;

import com.rodolfoba.bookmark.domain.BookmarkService;

public class DeleteByIdUseCase extends AbstractBookmarkUseCase<Void> {

    private BookmarkService bookmarkService;
    private UUID id;

	private DeleteByIdUseCase(BookmarkUseCaseConfig config, UUID id) {
	    super(config.transactionalContext);
	    this.bookmarkService = config.bookmarkService;
	    this.id = id;
	}

	@Override
	protected Void realiza() {
		bookmarkService.deleteById(id);
		return null;
	}
	
	public static void executa(BookmarkUseCaseConfig config, UUID id) {
		new DeleteByIdUseCase(config,  id).aciona();
	}
}