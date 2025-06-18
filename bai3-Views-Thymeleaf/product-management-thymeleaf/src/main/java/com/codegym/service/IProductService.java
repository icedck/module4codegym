package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    public List<Product> getAllProducts();

    public Product getProductById(int id);

    public void addProduct(Product product);
    public void updateProduct(int id, Product product);
    public void deleteProduct(int id);

    public List<Product> getProductsByName(String name);
}
