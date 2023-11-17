package com.ust.app.foodmenu.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.ust.app.foodmenu.exception.InvalidCategoryException;
import com.ust.app.foodmenu.exception.ItemAlreadyExistsException;
import com.ust.app.foodmenu.exception.ItemNotFoundException;
import com.ust.app.foodmenu.model.Category;
import com.ust.app.foodmenu.model.MenuItem;
import com.ust.app.foodmenu.model.Status;

@Repository
public class FoodMenuRepositoryImpl implements FoodMenuRepository {

	List<MenuItem> menuItems = new ArrayList<>();

	@Override
	public MenuItem addItem(MenuItem item) {

		if (item != null) {
			for (MenuItem i : menuItems) {
				if (i.equals(item)) {
					throw new ItemAlreadyExistsException("This item already exist in menu add another");
				}
			}
			menuItems.add(item);
			return item;
		}
		return null;
	}

	@Override
	public void deleteItem(long id) {
		for (MenuItem m : menuItems) {
			if (m.getMenuItemId() == id) {
				menuItems.remove(m);
			}
		}

	}

	@Override
	public MenuItem updatePrice(long id, MenuItem item) {
		MenuItem updatedItem = menuItems.stream().filter(i -> i.getMenuItemId() == id).findFirst().get();	
			updatedItem.setPrice(item.getPrice());
			return updatedItem;
	}

	@Override
	public MenuItem getItemByName(String name) {
		return menuItems.stream().filter(i -> i.getItemName().equalsIgnoreCase(name.trim())).findFirst()
				.orElseThrow(() -> new ItemNotFoundException("Item with name " + name + " Not found"));
	}

	@Override
	public List<MenuItem> getAllItems() {
		return menuItems;
	}

	@Override
	public List<MenuItem> getItemsByCategory(String category) {

		boolean isValid = false;

		for (Category val : Category.values()) {
			if (String.valueOf(val).equalsIgnoreCase(category)) {
				isValid = true;
				break;
			}
		}
		if (isValid) {
			return menuItems.stream().filter(i -> String.valueOf(i.getCategory()).equalsIgnoreCase(category.toUpperCase()))
					.collect(Collectors.toList());
		} else
			throw new InvalidCategoryException("The given category: " + category + " is invalid");

	}

}
