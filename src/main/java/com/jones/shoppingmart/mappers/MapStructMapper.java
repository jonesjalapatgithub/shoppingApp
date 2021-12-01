package com.jones.shoppingmart.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.jones.shoppingmart.entity.Booking;
import com.jones.shoppingmart.model.OrderModel;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
	
	MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);
	
	Booking orderModelToBooking(OrderModel orderModel);

}
