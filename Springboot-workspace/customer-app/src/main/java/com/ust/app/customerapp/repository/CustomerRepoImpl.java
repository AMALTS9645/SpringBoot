package com.ust.app.customerapp.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.ust.app.customerapp.exception.CustomerAlreadyExistsException;
import com.ust.app.customerapp.exception.CustomerNotFoundException;
import com.ust.app.customerapp.model.Customer;

@Repository
public class CustomerRepoImpl implements CustomerRepo{
	
	List<Customer> customerData;
	
	@PostConstruct
	public void initCustomers() {
		customerData   = new ArrayList<>();
		customerData.add(new Customer(1001,"amal","amal@gmail.com",LocalDate.parse("1998-11-24")));
		customerData.add(new Customer(1002,"nawal","amal@gmail.com",LocalDate.parse("1998-11-24")));
		customerData.add(new Customer(1003,"akshara","amal@gmail.com",LocalDate.parse("1998-11-24")));
		
	}

	@Override
	public Customer addCustomer(Customer customer) {
		if(customer != null) {
			for(Customer c: customerData) {
				if(c.equals(customer)) {
					throw new CustomerAlreadyExistsException("Given Customer Already Exist");
				}
			}
			customerData.add(customer);
		}
		return customer;
	}

	
	@Override
	public Customer getCustomer(int id) {
		Customer c = null;
		for(Customer cus : customerData) {
			if(cus.getId() == id) {
				c = cus;
			}
		}
		if(c==null) {
			throw new CustomerNotFoundException("Customer with id "+id+" Not found");
		}
		return c;
	}

	@Override
	public Customer updateCustomer(Customer customer,int id) {
		Customer c = getCustomer(id);
		
		c.setId(customer.getId());
		c.setName(customer.getName());
		c.setEmail(customer.getEmail());
		c.setDob(customer.getDob());
		
		return c;
	}

	@Override
	public void deleteCustomer(int id) {
		Customer c = getCustomer(id);
		customerData.remove(c);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerData;
	}

	@Override
	public Customer getCustomerByName(String name) {
		Customer c = null;
		for(Customer cus : customerData) {
			if(cus.getName().equalsIgnoreCase(name)) {
				c = cus;
			}
		}
		return c;
	}

}
