package com.jones.shoppingmart.helper;

import java.util.ArrayList;
import java.util.List;

import com.jones.shoppingmart.model.Product;

public class ProductGenerator {
	
	private ProductGenerator() {}
	
	private static List<Product> products = createProductList();
	

	private static java.util.List<Product> createProductList() {
		List<Product> products = new ArrayList<Product>();
		Product product2 = new Product(2, "Second Product", "Description");
		Product product3 = new Product(3, "Third Product", "Description");
		Product product1 = new Product(1, "First Product", "Description");
		products.add(product1);
		products.add(product2);
		products.add(product3);
		return products;
	}
	
	public static List<Product> getProducts() {
		return products;
	}

}
