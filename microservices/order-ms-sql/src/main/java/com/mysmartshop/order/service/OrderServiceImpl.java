package com.mysmartshop.order.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mysmartshop.order.dto.CartDetails;
import com.mysmartshop.order.dto.CartItem;
import com.mysmartshop.order.model.OrderItem;
import com.mysmartshop.order.repository.OrderRepository;

@Service
public class OrderServiceImpl  implements OrderService{

	@Autowired
	private OrderRepository repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public OrderItem getOrderDetails(int orderId) {
		return repo.findById(orderId).get();
	}
	
	@Override
	public OrderItem placeOrder(List<CartItem> cartItems) {
		OrderItem orderDetails = new OrderItem();
		orderDetails.setOrderItems(cartItems);
		orderDetails.setOrderStatus(true);
		Random rnd = new Random();
		int num = rnd.nextInt(900000)+100000;
		orderDetails.setOrderId(num);
		return repo.save(orderDetails);
	}

	@Override
	public CartDetails getCartItems() {
		// TODO Auto-generated method stub
		return fetchCartItems();
	}
	
	
	private CartDetails fetchCartItems() {
		CartDetails cartItems = restTemplate.getForObject("http://cart-ms/cart/items",CartDetails.class);
		return cartItems;
	}

	@Override
	public List<OrderItem> getAllItems() {
		// TODO Auto-generated method stub
		List<OrderItem> item = repo.findAll();
		return item;
	}
	
}

