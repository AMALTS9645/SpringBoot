package com.mysmartshop.order.service;

import java.util.List;

import com.mysmartshop.order.dto.CartDetails;
import com.mysmartshop.order.dto.CartItem;
import com.mysmartshop.order.model.OrderItem;

public interface OrderService {

	/*
	 * 
	 *  +placeOrder(cartItems: List<CartItem>): Order
  		+getOrderDetails(orderId: String): Order
  		+updateOrderStatus(orderId: String, status: String): void
  		+cancelOrder(orderId: String): void
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	public OrderItem placeOrder(List<CartItem> cartItems);
	
	public OrderItem getOrderDetails(int orderId);
	
	public CartDetails getCartItems();
	
	public List<OrderItem> getAllItems();
	
}

