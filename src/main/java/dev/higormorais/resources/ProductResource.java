package dev.higormorais.resources;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dev.higormorais.dto.requests.ProductRequest;
import dev.higormorais.services.ProductService;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {
	
	@Inject
	private ProductService productService;
	
	// ------------------------------------------------------------------------------------------------
	
	@GET
	public Response findAll() {
		return Response.ok(productService.findAll()).build();
	}
	
	@GET
	@Path("/{id}")
	public Response findById(@PathParam("id") Long id) {
		return Response.ok(productService.findById(id)).build();
	}
	
	@POST
	@Transactional
	public Response create(@Valid ProductRequest product) {
		
		productService.create(product);
		
		return Response.status(201).build();
	}
	
	@PUT
	@Path("/{id}")
	@Transactional
	public Response update(@PathParam("id") Long id, @Valid ProductRequest product) {
		
		productService.update(id, product);
		
		return Response.status(204).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Transactional
	public Response delete(@PathParam("id") Long id) {
		
		productService.delete(id);
		
		return Response.status(204).build();
	}

}
