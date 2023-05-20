package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.CartItem;
import com.example.demo.entities.Product;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

	List<CartItem> findAllByProduct(Product product);
}
