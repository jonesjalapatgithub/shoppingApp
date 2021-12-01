package com.jones.shoppingmart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype 	.Component;

import com.jones.shoppingmart.entity.Booking;
import com.jones.shoppingmart.mappers.MapStructMapper;
import com.jones.shoppingmart.model.OrderModel;
import com.jones.shoppingmart.repository.OrderRepository;

@Component
public class OrderService {
	
	private OrderRepository orderRepository;
	
	@Autowired
    MapStructMapper mapstructMapper;

	@Autowired
	public OrderService( OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}
	
	public void saveOrder(OrderModel orderModel) {
		try {
			Booking order = mapstructMapper.orderModelToBooking(orderModel);
			orderRepository.save(order);
		} catch (Exception e) {
			throw new RuntimeException("Error from bookingConfirmation");
		}
	}

	
	
	
	


}
