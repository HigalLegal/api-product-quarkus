package dev.higormorais.configs;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.modelmapper.ModelMapper;

@ApplicationScoped
public class MapperConfig {
	
	@Produces
	public ModelMapper mapper() {
		return new ModelMapper();
	}
}
