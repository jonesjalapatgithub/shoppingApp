package com.jones.shoppingmart.repository;

import org.springframework.data.repository.CrudRepository;

import com.jones.shoppingmart.entity.Booking;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface OrderRepository extends CrudRepository<Booking, Integer>{

}
