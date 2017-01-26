package com.rodolfoba.bookmark.adapter.jpa;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity(name = "Bookmark")
class BookmarkEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * If you are using Glassfish then remove the strategy attribute
	 */
	@Id
	@NotNull
	private UUID id;

	@NotNull
	@Size(min = 1, message = "{required.field}")
	private String description;

	@NotNull
	@Size(min = 1, message = "{required.field}")
	@Pattern(regexp = "^|([a-zA-Z]+://)(\\w+\\.\\w+)(.+)?$", message = "{invalid.url}")
	private String link;

	public BookmarkEntity() {
	
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
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
		BookmarkEntity other = (BookmarkEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
