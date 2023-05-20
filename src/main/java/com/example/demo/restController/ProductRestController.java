package com.example.demo.restController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/magasin")
public class ProductRestController {
	
	private ProductService productService;
	 @PostMapping
	    public ResponseEntity<Product> createProduct(@RequestBody Product product){
		 Product savedProduct = productService.createProduct(product);
	        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	    }
	 
	 @GetMapping
	    public ResponseEntity<List<Product>> getAllProducts(){
	        List<Product> product = productService.getAllProducts();
	        return new ResponseEntity<>(product, HttpStatus.OK);
	    }
}
