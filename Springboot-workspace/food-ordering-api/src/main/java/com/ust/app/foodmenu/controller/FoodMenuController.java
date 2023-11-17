package com.ust.app.foodmenu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ust.app.foodmenu.model.Category;
import com.ust.app.foodmenu.model.MenuItem;
import com.ust.app.foodmenu.service.FoodMenuService;


@CrossOrigin
@RestController
@RequestMapping("/api/v1/foodmenu")
public class FoodMenuController {
	
	@Autowired
	FoodMenuService service;

	@GetMapping
	public List<MenuItem> getAll(){
		return service.getAllItems();
	}
	
	@PostMapping
	public MenuItem addItems(@RequestBody MenuItem item){
		return service.addItem(item);
	}
	
	@DeleteMapping("/{id}")
	public void deleteItem(@PathVariable long id) {
		service.deleteItem(id);
	}
	
	@PutMapping("/{id}")
	public MenuItem updateItem(@PathVariable long id,@RequestBody MenuItem item) {
		return service.updatePrice(id, item);
	}
	
	@GetMapping("/searchname")
	public MenuItem getItemByName(@RequestParam("name") String name){
		return service.getItemByName(name);
	}
	
	@GetMapping("/category")
	public List<MenuItem> getItemsByCategory(@RequestParam("category") String category){
		return service.getItemsByCategory(category);
	}
	
	
}
