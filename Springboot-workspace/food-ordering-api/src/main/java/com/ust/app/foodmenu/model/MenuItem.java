package com.ust.app.foodmenu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MenuItem {
	
	private long menuItemId;
	private String itemName;
	private Status status;
	private double price;
	private Category category;
}
