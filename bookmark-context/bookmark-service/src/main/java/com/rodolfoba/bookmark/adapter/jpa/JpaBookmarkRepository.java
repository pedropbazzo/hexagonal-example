package com.rodolfoba.bookmark.adapter.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.rodolfoba.bookmark.domain.Bookmark;
import com.rodolfoba.bookmark.domain.BookmarkRepository;
import com.rodolfoba.infra.persistence.jpa.GenericJpaRepository;

public class JpaBookmarkRepository extends GenericJpaRepository implements BookmarkRepository {

	private static final long serialVersionUID = 1L;
	
	public JpaBookmarkRepository(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public void insert(Bookmark bookmark) {
		BookmarkEntity bookmarkEntity = Assembler.disassemble(bookmark);
		getEntityManager().persist(bookmarkEntity);
	}

	@Override
	public void update(Bookmark bookmark) {
		getEntityManager().merge(Assembler.disassemble(bookmark));
	}

	@Override
	public void deleteById(UUID id) {
		BookmarkEntity entity = getEntityManager().getReference(BookmarkEntity.class, id);
		getEntityManager().remove(entity);
	}

	@Override
	public List<Bookmark> findAll() {
		String jpql = "select this from Bookmark this";
		TypedQuery<BookmarkEntity> listQuery = getEntityManager().createQuery(jpql, BookmarkEntity.class);
		return Assembler.assemble(listQuery.getResultList());
	}

	@Override
	public Bookmark load(UUID id) {
		return Assembler.assemble(getEntityManager().find(BookmarkEntity.class, id));
	}

	public static class Assembler {

		public static Bookmark assemble(BookmarkEntity entity) {
			Bookmark bookmark = new Bookmark(entity.getId(), entity.getDescription(), entity.getLink());
			return bookmark;
		}

		public static List<Bookmark> assemble(List<BookmarkEntity> entities) {
			ArrayList<Bookmark> list = new ArrayList<Bookmark>();
			for (BookmarkEntity entity : entities) {
				list.add(assemble(entity));
			}
			return list;
		}

		public static BookmarkEntity disassemble(Bookmark bookmark) {
			BookmarkEntity entity = new BookmarkEntity();
			entity.setId(bookmark.getId());
			entity.setDescription(bookmark.getDescription());
			entity.setLink(bookmark.getLink());
			return entity;
		}

	}
}
