package dev.higormorais.handlers.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ErrorMessage {

	private String title;
	private Integer statusCode;
	private String message;

}