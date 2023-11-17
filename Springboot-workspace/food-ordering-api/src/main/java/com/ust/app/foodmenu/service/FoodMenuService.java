package com.ust.app.foodmenu.service;

import java.util.List;

import com.ust.app.foodmenu.model.Category;
import com.ust.app.foodmenu.model.MenuItem;

public interface FoodMenuService {
	public MenuItem addItem(MenuItem item);

	public void deleteItem(long id);

	public MenuItem updatePrice(long id, MenuItem item);

	public MenuItem getItemByName(String name);

	public List<MenuItem> getAllItems();

	public List<MenuItem> getItemsByCategory(String  category);

}
