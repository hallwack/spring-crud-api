package com.springcrudapi.models.repos;

import java.util.List;

import com.springcrudapi.models.entities.Products;

import org.springframework.data.repository.CrudRepository;

public interface ProductsRepo extends CrudRepository<Products, Long> {

    List<Products> findByNameContains(String name);
}
