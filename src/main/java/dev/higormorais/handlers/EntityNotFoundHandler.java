package dev.higormorais.handlers;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import dev.higormorais.handlers.entities.ErrorMessage;

@Provider
public class EntityNotFoundHandler implements ExceptionMapper<EntityNotFoundException> {

	@Override
	public Response toResponse(EntityNotFoundException exception) {
		
		var errorMessage = new ErrorMessage("NOT FOUND", 404 , "Entity not found.");
		
		return Response
				.status(errorMessage.getStatusCode())
				.entity(errorMessage)
				.build();
	}

}
