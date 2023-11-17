package com.mysmartshop.order.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CartItem {

	@Id
//	@GeneratedValue
//	@Column(name="cart_id")
	private int cartId;
	private String productId;
	private String productName;
	private int quantity;
	private float totalPrice;
	
}
