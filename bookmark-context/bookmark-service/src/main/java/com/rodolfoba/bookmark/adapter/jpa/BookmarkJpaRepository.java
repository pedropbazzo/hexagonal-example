package com.rodolfoba.bookmark.adapter.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.rodolfoba.bookmark.domain.Bookmark;
import com.rodolfoba.bookmark.domain.BookmarkRepository;
import com.rodolfoba.bookmark.infra.persistence.jpa.GenericJpaRepository;

public class BookmarkJpaRepository extends GenericJpaRepository implements BookmarkRepository {

	private static final long serialVersionUID = 1L;
	
	public BookmarkJpaRepository(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public void insert(Bookmark bookmark) {
		BookmarkJpaEntity bookmarkJpaEntity = Assembler.disassemble(bookmark);
		getEntityManager().persist(bookmarkJpaEntity);
	}

	@Override
	public void update(Bookmark bookmark) {
		getEntityManager().merge(Assembler.disassemble(bookmark));
	}

	@Override
	public void deleteById(UUID id) {
		BookmarkJpaEntity entity = getEntityManager().getReference(BookmarkJpaEntity.class, id);
		getEntityManager().remove(entity);
	}

	@Override
	public List<Bookmark> findAll() {
		String jpql = "select this from Bookmark this";
		TypedQuery<BookmarkJpaEntity> listQuery = getEntityManager().createQuery(jpql, BookmarkJpaEntity.class);
		return Assembler.assemble(listQuery.getResultList());
	}

	@Override
	public Bookmark load(UUID id) {
		return Assembler.assemble(getEntityManager().find(BookmarkJpaEntity.class, id));
	}

	public static class Assembler {

		public static Bookmark assemble(BookmarkJpaEntity entity) {
			Bookmark bookmark = new Bookmark(entity.getId(), entity.getDescription(), entity.getLink());
			return bookmark;
		}

		public static List<Bookmark> assemble(List<BookmarkJpaEntity> entities) {
			ArrayList<Bookmark> list = new ArrayList<Bookmark>();
			for (BookmarkJpaEntity entity : entities) {
				list.add(assemble(entity));
			}
			return list;
		}

		public static BookmarkJpaEntity disassemble(Bookmark bookmark) {
			BookmarkJpaEntity entity = new BookmarkJpaEntity();
			entity.setId(bookmark.getId());
			entity.setDescription(bookmark.getDescription());
			entity.setLink(bookmark.getLink());
			return entity;
		}

	}
}
