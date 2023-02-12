package dev.higormorais.dto.requests;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder @Jacksonized
public class ProductRequest {
	
	@NotBlank(message = "Name cannot be blank!")
	private String name;
	
	@NotBlank(message = "Description cannot be blank!")
	private String description;
	
	@NotBlank(message = "Category cannot be blank!")
	private String category;
	
	@NotBlank(message = "Model cannot be blank!")
	private String model;
	
	@NotNull(message = "Price cannot be null!")
	private BigDecimal price;

}
