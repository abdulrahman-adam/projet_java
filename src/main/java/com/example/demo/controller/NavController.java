package com.example.demo.controller;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class NavController {
	 @GetMapping("/")
	    public String index() {
	    	
	        return "navbar";
	    }

	 @GetMapping("/panier")
	    public String panier() {
	    	
	        return "panier";
	    }

}
