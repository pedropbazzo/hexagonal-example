package com.rodolfoba.bookmark.infra.bootstrap;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.demoiselle.jee.core.lifecycle.annotation.Startup;

import com.rodolfoba.bookmark.application.BookmarkUseCaseFactory;
import com.rodolfoba.bookmark.application.CreateBookmarkCommand;
import com.rodolfoba.bookmark.application.FindAllBookmarksUseCase;
import com.rodolfoba.bookmark.application.InsertBookmarkUseCase;

@ApplicationScoped
public class ApplicationBootstrap {

    @Inject
    private BookmarkUseCaseFactory bookmarkUseCaseFactory;
    
	@Startup
	public void load() {

		FindAllBookmarksUseCase findAllBookmarksUseCase = bookmarkUseCaseFactory.createFindAllBookmarksUseCase();
		if (findAllBookmarksUseCase.aciona().isEmpty()) {
			insere("Portal", "http://www.frameworkdemoiselle.gov.br");
			insere("Documentação", "http://demoiselle.sourceforge.net/docs/framework/reference");
			insere("Fórum", "http://pt.stackoverflow.com/tags/demoiselle");
			insere("Lista de usuários", "https://lists.sourceforge.net/lists/listinfo/demoiselle-users");
			insere("Blog oficial", "http://frameworkdemoiselle.wordpress.com");
			insere("Blog experimental", "http://demoisellelab.wordpress.com");
			insere("Repositório", "http://github.com/demoiselle/framework");
			insere("Bug Tracker", "https://demoiselle.atlassian.net");
			insere("Facebook", "http://facebook.com/FrameworkDemoiselle");
			insere("Twitter", "http://twitter.com/fwkdemoiselle");
			insere("Binários", "http://sourceforge.net/projects/demoiselle/files/framework");
		}
	}

	private void insere(String description, String link) {
		InsertBookmarkUseCase useCase = bookmarkUseCaseFactory.createInsertBookmarkUseCase(obtemCreateBookmarkCommand(description, link));
	    useCase.aciona();
	}

	private CreateBookmarkCommand obtemCreateBookmarkCommand(String description, String link) {
		CreateBookmarkCommand command = new CreateBookmarkCommand();
		command.description = description;
		command.link = link;
		return command;
	}
}