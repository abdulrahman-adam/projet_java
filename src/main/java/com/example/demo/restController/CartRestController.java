package com.example.demo.restController;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.CartItem;
import com.example.demo.services.CartItemService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/")
public class CartRestController {
	@Autowired
	private CartItemService cartItemService;
	
	    @GetMapping("/all")
	    public List<CartItem> getAllYourEntities() {
	        return cartItemService.findAll();
	    }
	    
	    
	@PostMapping
    public ResponseEntity<CartItem> addItemToCart(@RequestBody CartItem cartItem){
		CartItem saveCart = cartItemService.addItemToCart(cartItem);
        return new ResponseEntity<>(saveCart, HttpStatus.CREATED);
    }
 

}
