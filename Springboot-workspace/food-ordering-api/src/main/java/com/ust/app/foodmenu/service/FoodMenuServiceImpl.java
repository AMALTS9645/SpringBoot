package com.ust.app.foodmenu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.app.foodmenu.model.Category;
import com.ust.app.foodmenu.model.MenuItem;
import com.ust.app.foodmenu.repository.FoodMenuRepository;

@Service
public class FoodMenuServiceImpl implements FoodMenuService{

	@Autowired
	FoodMenuRepository repo;
	
	@Override
	public MenuItem addItem(MenuItem item) {
		return repo.addItem(item);
	}

	@Override
	public void deleteItem(long id) {
		repo.deleteItem(id);
		
	}

	@Override
	public MenuItem updatePrice(long id, MenuItem item) {
		return repo.updatePrice(id, item);
	}

	@Override
	public MenuItem getItemByName(String name) {
		return repo.getItemByName(name);
	}

	@Override
	public List<MenuItem> getAllItems() {
		return repo.getAllItems();
	}

	@Override
	public List<MenuItem> getItemsByCategory(String  category) {
		return repo.getItemsByCategory(category);
	}
	

}
