package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public Product getProductById(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.get();
	}

	@Override
	public List<Product> getAllProducts() {
			  List<Product> list =  (List<Product>)productRepository.findAll();
			  return list;
		//return productRepository.findAll();
	}

	@Override
	public Product updateProduct(Product product) {
		Product existingProduct = productRepository.findById(product.getId()).get();
		
		existingProduct.setNom(product.getNom());
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setCategory(product.getCategory());
		
		Product updatedProduct = productRepository.save(existingProduct);
	        return updatedProduct;
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
		
	}

}
