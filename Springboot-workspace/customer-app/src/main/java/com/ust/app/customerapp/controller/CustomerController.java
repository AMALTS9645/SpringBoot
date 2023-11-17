package com.ust.app.customerapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ust.app.customerapp.model.Customer;
import com.ust.app.customerapp.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		return service.addCustomer(customer);
	}
	
	@GetMapping
	public List<Customer> getAllCustomers(){
		return service.getAllCustomers();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public Customer getAllCustomers(@PathVariable int id){
		return service.getCustomer(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public Customer updateCustomers(@RequestBody Customer customer,@PathVariable int id){
		return service.updateCustomer(customer, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteCustomer(@PathVariable int id) {
		service.deleteCustomer(id);
	}
	
	@GetMapping("/search")
	@ResponseStatus(value = HttpStatus.OK)
	public Customer getAllCustomers(@RequestParam("name") String name){
		return service.getCustomerByName(name);
	}
}
