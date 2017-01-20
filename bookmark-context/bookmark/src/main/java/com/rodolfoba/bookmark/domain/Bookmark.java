package com.rodolfoba.bookmark.domain;

import java.io.Serializable;
import java.util.UUID;

public class Bookmark implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID id;
	private String description;
	private String link;

	public Bookmark(UUID id, String description, String link) {
		this.id = id;
		this.description = description;
		this.link = link;
	}

	public Bookmark(String description, String link) {
		this.id = UUID.randomUUID();
		this.description = description;
		this.link = link;
	}

	public UUID getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}

	public String getLink() {
		return link;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bookmark other = (Bookmark) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}