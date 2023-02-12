package dev.higormorais.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	private String category;
	private String model;
	private BigDecimal price;

}
