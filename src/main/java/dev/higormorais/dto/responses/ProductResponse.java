package dev.higormorais.dto.responses;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder @Jacksonized
public class ProductResponse {
	
	private Long id;
	private String name;
	private String description;
	private String category;
	private String model;
	private BigDecimal price;

}
