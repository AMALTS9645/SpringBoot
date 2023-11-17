package com.mysmartshop.order.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mysmartshop.order.dto.CartDetails;
import com.mysmartshop.order.model.OrderItem;
import com.mysmartshop.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
//	@Autowired
//	RestTemplate restClient;

	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public String greet() {
		return "Message from Order Service";
	}
	
	@PostMapping
	public OrderItem placeOrder(@RequestBody OrderItem order) {
		return orderService.placeOrder(order.getOrderItems());
	}
	
	@GetMapping("/{orderId}")
	public OrderItem getOrderDetails(@PathVariable int orderId) {
		return orderService.getOrderDetails(orderId);
	}

	
	@GetMapping("/getCartItems")
	public CartDetails getCartItems() {
		return orderService.getCartItems();
	}
	
	@GetMapping("/getall")
	public List<OrderItem> getAllItems() {
		return orderService.getAllItems();
	}

}
