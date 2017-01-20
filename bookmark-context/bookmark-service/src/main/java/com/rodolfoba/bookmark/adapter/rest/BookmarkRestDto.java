package com.rodolfoba.bookmark.adapter.rest;

import java.util.UUID;

class BookmarkRestDto {

	public UUID id;
	public String description;
	public String link;

	public BookmarkRestDto() {
		super();
	}
	
	public BookmarkRestDto(UUID id, String description, String link) {
		super();
		this.id = id;
		this.description = description;
		this.link = link;
	}
	
}
