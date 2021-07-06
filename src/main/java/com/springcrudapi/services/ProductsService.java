package com.springcrudapi.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.springcrudapi.models.entities.Products;
import com.springcrudapi.models.repos.ProductsRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductsService {

    @Autowired
    private ProductsRepo productsRepo;

    public Products save(Products products) {
        return productsRepo.save(products);
    }

    public Products findById(Long id) {
        Optional<Products> product = productsRepo.findById(id);

        if (!product.isPresent()) {
            return null;
        }

        return product.get();
    }

    public Iterable<Products> findAll() {
        return productsRepo.findAll();
    }

    public void removeById(Long id) {
        productsRepo.deleteById(id);
    }

    public List<Products> findByName(String name) {
        return productsRepo.findByNameContains(name);
    }
}
