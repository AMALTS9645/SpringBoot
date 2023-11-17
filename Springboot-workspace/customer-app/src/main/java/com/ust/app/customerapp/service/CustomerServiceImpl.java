package com.ust.app.customerapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.app.customerapp.model.Customer;
import com.ust.app.customerapp.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepo.addCustomer(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		return customerRepo.getCustomer(id);
	}

	@Override
	public Customer updateCustomer(Customer customer,int id) {
		return customerRepo.updateCustomer(customer,id);
	}

	@Override
	public void deleteCustomer(int id) {
		customerRepo.deleteCustomer(id);
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepo.getAllCustomers();
	}

	@Override
	public Customer getCustomerByName(String name) {
		return customerRepo.getCustomerByName(name);
	}

}
