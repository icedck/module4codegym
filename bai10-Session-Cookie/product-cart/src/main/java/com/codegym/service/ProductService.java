package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private IProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(int id) {
        return repository.findById(id).orElse(null);
    }
}
