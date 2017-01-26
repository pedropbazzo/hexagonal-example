package com.rodolfoba.bookmark.adapter.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.rodolfoba.bookmark.application.BookmarkApplication;
import com.rodolfoba.bookmark.application.InsertBookmarkCommand;
import com.rodolfoba.bookmark.application.UpdateBookmarkCommand;
import com.rodolfoba.bookmark.domain.Bookmark;

@Path("bookmarks")
@RequestScoped
public class BookmarkRestAdapter {

    @Inject
    private BookmarkApplication bookmarkApplication;
    
	@GET
	@Produces("application/json")
	public List<BookmarkRestDto> findAll() {
		List<BookmarkRestDto> dtos = new ArrayList<>();
		for (Bookmark bookmark : bookmarkApplication.findAll()) {
			dtos.add(new BookmarkRestDto(bookmark.getId(), bookmark.getDescription(), bookmark.getLink()));
		}
		return dtos;
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public BookmarkRestDto load(@PathParam("id") UUID id) {
		Bookmark result = bookmarkApplication.load(id);

		if (result == null) {
			throw new NotFoundException();
		}
		
		return new BookmarkRestDto(result.getId(), result.getDescription(), result.getLink());
	}

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response insert(BookmarkRestDto request, @Context UriInfo uriInfo) {
		checkId(request);

		InsertBookmarkCommand command = new InsertBookmarkCommand();
		command.description = request.description;
		command.link = request.link;
		
		UUID id = bookmarkApplication.insert(command);
		
		URI location = uriInfo.getRequestUriBuilder().path(id.toString()).build();
		return Response.created(location).entity(request.id).build();
	}

	@PUT
	@Path("{id}")
	@Produces("application/json")
	@Consumes("application/json")
	public void update(@PathParam("id") UUID id, BookmarkRestDto request) {
		checkId(request);
		
		UpdateBookmarkCommand command = new UpdateBookmarkCommand();
		command.id = id;
		command.description = request.description;
		command.link = request.link;
		
		bookmarkApplication.update(command);
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") UUID id) {
		bookmarkApplication.delete(id);
	}

	private void checkId(BookmarkRestDto request) {
		if (request.id != null) {
			throw new BadRequestException();
		}
	}
}