package com.jones.shoppingmart.service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.eventbus.EventBus;
import com.jones.shoppingmart.helper.ProductGenerator;
import com.jones.shoppingmart.model.Product;
import com.jones.shoppingmart.monitoring.LoggingEntity;

@Component
public class ProductService {

	private EventBus eventBus;

	@Autowired
	public ProductService(EventBus eventBus) {
		this.eventBus = eventBus;
	}

	public Product getProductById(int id) {
		List<Product> products = getProducts();
		Map<Integer, Product> productMap = products.stream()
				.collect(Collectors.toMap(Product::getId, Function.identity()));
		Product product = productMap.get(id);
		LoggingEntity loggingEntity = LoggingEntity.builder().message("Product service call is success")
				.level(LoggingEntity.Level.INFO).status(LoggingEntity.Status.SUCCESS).method("ProductService.getProductById").build();
		this.eventBus.post(loggingEntity);
		return product;
	}

	public List<Product> getProducts() {
		return ProductGenerator.getProducts();
	}

}
