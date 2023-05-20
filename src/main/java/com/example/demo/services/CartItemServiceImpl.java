package com.example.demo.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.CartItem;

import com.example.demo.repositories.CartItemRepository;

@Service
public class CartItemServiceImpl implements CartItemService{
	  
	@Autowired
	private  CartItemRepository cartItemRepository;
	
	@Override
	public List<CartItem> findAll() {
		// TODO Auto-generated method stub
		 return cartItemRepository.findAll();
	}

	@Override
	public CartItem addItemToCart(CartItem cartItem) {
		 return cartItemRepository.save(cartItem);
		
	}

	@Override
	public void removeItemFromCart(Long id) {
		cartItemRepository.deleteById(id);
		
	}

}







