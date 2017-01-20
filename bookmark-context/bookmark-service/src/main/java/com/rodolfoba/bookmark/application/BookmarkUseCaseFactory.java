package com.rodolfoba.bookmark.application;

import java.util.UUID;

public interface BookmarkUseCaseFactory {

	FindAllBookmarksUseCase createFindAllBookmarksUseCase();

	LoadBookmarkUseCase createLoadBookmarkUseCase(UUID id);

	InsertBookmarkUseCase createInsertBookmarkUseCase(CreateBookmarkCommand command);

	UpdateBookmarkUseCase createUpdateBookmarkUseCase(UpdateBookmarkCommand command);

	DeleteByIdUseCase createDeleteByIdUseCase(UUID id);

}
