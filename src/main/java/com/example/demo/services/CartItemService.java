package com.example.demo.services;



import java.util.List;

import com.example.demo.entities.CartItem;


public interface CartItemService {
	 List<CartItem> findAll();
	 
	 
	
	 
	CartItem addItemToCart(CartItem cartItem);
	public void removeItemFromCart(Long id);
}
