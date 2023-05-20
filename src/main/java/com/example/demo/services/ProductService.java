package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Product;



public interface ProductService {

	Product createProduct(Product product);

	Product getProductById(Long id);

	    List<Product> getAllProducts();

	    Product updateProduct(Product product);

	    void deleteProduct(Long id);
}
