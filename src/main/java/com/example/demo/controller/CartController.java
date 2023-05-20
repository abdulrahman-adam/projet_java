package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.CartItem;
import com.example.demo.services.CartItemService;

@Controller
public class CartController {
	
	  private final CartItemService cartItemService;

	    public CartController(CartItemService cartItemService) {
	        this.cartItemService = cartItemService;
	    }
	    
	    @GetMapping("/carts")
	    public String getAllYourEntities(Model model) {
	        List<CartItem> cartItems = cartItemService.findAll();
	        model.addAttribute("cartItem", cartItems);
	        return "panier"; // assuming you have a Thymeleaf template named "your-entity-list.html"
	    }

	    @PostMapping("/cart/add")
	    public String addToCart(@ModelAttribute("cartItem") CartItem cartItem) {
	        cartItemService.addItemToCart(cartItem);
	        return "redirect:/panier";
	    }

	    @PostMapping("/cart/remove/{id}")
	    public String removeFromCart(@PathVariable Long id) {
	        cartItemService.removeItemFromCart(id);
	        return "redirect:/panier";
	    }
}
