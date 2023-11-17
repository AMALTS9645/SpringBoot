package com.mysmartshop.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysmartshop.order.model.OrderItem;

public interface OrderRepository extends JpaRepository<OrderItem, Integer> {

//	public OrderItem findByorderId(String orderId);
	
}
