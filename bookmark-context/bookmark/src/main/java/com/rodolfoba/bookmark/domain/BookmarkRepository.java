package com.rodolfoba.bookmark.domain;

import java.util.List;
import java.util.UUID;

public interface BookmarkRepository {

	List<Bookmark> findAll();

	void insert(Bookmark bookmark);

	void update(Bookmark bookmark);
	
	void deleteById(UUID id);

	Bookmark load(UUID id);

}
