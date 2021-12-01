package com.jones.shoppingmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.jones.shoppingmart.model.OrderModel;
import com.jones.shoppingmart.service.OrderService;

@RestController
public class OrderController {
	
	private OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/bookingConfirmation", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addBookingConfirmation(@RequestBody OrderModel orderModel) {
		
		orderService.saveOrder(orderModel);
		return ResponseEntity.ok(HttpStatus.CREATED);
	}	

}
