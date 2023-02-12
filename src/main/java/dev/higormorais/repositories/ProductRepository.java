package dev.higormorais.repositories;

import javax.enterprise.context.ApplicationScoped;

import dev.higormorais.entities.Product;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {

}
