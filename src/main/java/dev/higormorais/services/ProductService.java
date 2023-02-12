package dev.higormorais.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;

import dev.higormorais.dto.requests.ProductRequest;
import dev.higormorais.dto.responses.ProductResponse;
import dev.higormorais.entities.Product;
import dev.higormorais.repositories.ProductRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class ProductService {
	
	@Inject
	private ProductRepository productRepository;
	
	@Inject
	private ModelMapper modelMapper;
	
	// --------------------------------------------------------------------------------------------
	
	public List<ProductResponse> findAll() {
		
		PanacheQuery<Product> allEntities = productRepository.findAll();
				
		return allEntities.list()
				.stream()
				.map(product -> modelMapper.map(product, ProductResponse.class))
				.collect(Collectors.toList());
		
	}
	
	public ProductResponse findById(Long id) {
		
		if(productRepository.findByIdOptional(id).isEmpty()) {
			throw new EntityNotFoundException("Entity not found.");
		}
		
		return modelMapper.map(productRepository.findById(id), ProductResponse.class);
		
	}
	
	public void create(ProductRequest productRequest) {
		
		Product product = modelMapper.map(productRequest, Product.class);
		
		productRepository.persist(product);
	}
	
	public void update(Long id, ProductRequest productRequest) {
		
		if(productRepository.findByIdOptional(id).isEmpty()) {
			throw new EntityNotFoundException("Entity not found.");
		}
		
		Product product = modelMapper.map(productRequest, Product.class);
		product.setId(id);
		
		productRepository.getEntityManager().merge(product);
	}
	
	public void delete(Long id) {
		
		if(productRepository.findByIdOptional(id).isEmpty()) {
			throw new EntityNotFoundException("Entity not found.");
		}
		
		productRepository.deleteById(id);
	}
	
}
