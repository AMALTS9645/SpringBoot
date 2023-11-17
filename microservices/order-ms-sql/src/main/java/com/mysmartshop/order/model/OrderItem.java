package com.mysmartshop.order.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.mysmartshop.order.dto.CartItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	@OneToMany(targetEntity = CartItem.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinTable(name =  "order_cart")
	@JoinColumn(name = "oc_fk", referencedColumnName = "orderId")
	private List<CartItem> orderItems;
	private boolean orderStatus;
		

}

