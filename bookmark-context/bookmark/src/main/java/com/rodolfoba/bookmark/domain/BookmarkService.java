package com.rodolfoba.bookmark.domain;

import java.util.List;
import java.util.UUID;

public class BookmarkService {

	private BookmarkRepository repository;
	
	public BookmarkService(BookmarkRepository repository) {
		this.repository = repository;
	}
	
	public List<Bookmark> findAll() {
		return repository.findAll();
	}
	
	public void insert(Bookmark bookmark) {
		repository.insert(bookmark);
	}
	
	public void update(Bookmark bookmark) {
		repository.update(bookmark);
	}

	public Bookmark load(UUID id) {
		return repository.load(id);
	}

	public void deleteById(UUID id) {
		repository.deleteById(id);
	}
	
}
