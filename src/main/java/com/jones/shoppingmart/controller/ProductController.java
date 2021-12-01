package com.jones.shoppingmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jones.shoppingmart.model.Product;
import com.jones.shoppingmart.monitoring.MetricsListener;
import com.jones.shoppingmart.service.ProductService;


@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	MetricsListener metricsListerner;
	
	
	@CrossOrigin
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<?> getProducts() {
		List<Product> products = productService.getProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}	
	
	@CrossOrigin
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProductById(@PathVariable(name = "id") int id) {
		
		Product product = productService.getProductById(id);
		return ResponseEntity.ok(product);
	}	
	
	
	@GetMapping("/user")
	public String user() {
		return ("<h1>Welcome User</h1>");
	}
	
	@GetMapping("/admin")
	public String admin() {
		return ("<h1>Welcome admin</h1>");
	}
	

}
