package com.example.demo.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.ProductService;


import jakarta.servlet.http.HttpSession;


@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/product")
    public String showNewMaisonsForm(Model model) {
	  //Product product = new Product();
	  List<Product> product = productRepository.findAll();
        model.addAttribute("l", product);
        return "product";
    }
 
	
 @PostMapping("/product-add")
    public String saveProduct(@ModelAttribute("l") Product product, @RequestParam MultipartFile img, HttpSession session) {
	  
	 productService.createProduct(product);
	 //LASECTION DE L'IMAGE
	 //Product product = new Product();
	 product.setName(img.getOriginalFilename());
    
	 Product uploadImg = productRepository.save(product);
     if(uploadImg !=null) {
     	try {
			File saveFile = new ClassPathResource("static/img").getFile();
			Path path = Paths.get(saveFile.getAbsolutePath()+File.separator+img.getOriginalFilename());
			Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			} catch (Exception e) {
				e.printStackTrace();
			}
     }
     session.setAttribute("msg", "Image Upload Sucessfully");

    return "redirect:/products";
        //return "product";
    }
 
 
 // FINDALL
 @GetMapping("/products")
 public String getAllProducts(Model model) {
	 Iterable<Product> product = productService.getAllProducts();
     model.addAttribute("product", product);
     return "product-add";
 }
 
 //FINDBYID
 @GetMapping("/products/{id}")
 public String getProduct(@PathVariable("id") Long id, Model model) {
     Product product = productRepository.findById(id).orElse(null);
     model.addAttribute("product", product);
     return "product_id";
 }
 
 @GetMapping("/products/edit/{id}")
 public String showEditForm(@PathVariable("id") Long id, Model model) {
     // Retrieve the user from the database
     Product product = productService.getProductById(id);
     
     // Add the user object to the model
     model.addAttribute("product", product);
     
     return "edit-product";
 }
 
 @PostMapping("/products/update/{id}")
 public String updateProduct(@PathVariable("id") Long id, @ModelAttribute("product") Product product) {
     // Update the user in the database
	 productService.updateProduct(product);
     
     return "redirect:/products";
 }

 
 /*@DeleteMapping("/products/delete/{id}")
 public String deleteProducts(@PathVariable("id") Long id) {
	 productRepository.deleteById(id);
     //return "redirect:/entities"; // Redirect to the list page after deletion
	 return "product-add";
 }*/
 
 @GetMapping("/products/delete/{id}")
 public String deleteUser(@PathVariable("id") long id, Model model) {
     Product product = productRepository.findById(id)
       .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
     productRepository.delete(product);
     return "redirect:/products";
     //return "product";
 }

}
	 
