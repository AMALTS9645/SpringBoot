package com.ust.app.customerapp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ust.app.customerapp.exception.CustomerAlreadyExistsException;
import com.ust.app.customerapp.exception.CustomerNotFoundException;
import com.ust.app.customerapp.model.Customer;
import com.ust.app.customerapp.model.UserType;

@SpringBootTest
//@TestInstance(Lifecycle.PER_CLASS)
class CustomerServiceIntegrationTest {

	@Autowired
	private CustomerService service;

//	@BeforeAll
//	public void setUp() {
//		Customer c1 = new Customer(101, "feril", "feril@gmail.com", LocalDate.parse("1998-10-23"), UserType.GENERAL);
//		Customer c2 = new Customer(102, "akshara", "akshara@gmail.com", LocalDate.parse("1998-10-23"), UserType.PREMIUM);
//		Customer c3 = new Customer(103, "anson", "anson@gmail.com", LocalDate.parse("1998-10-23"), UserType.GENERAL);
//		
//		service.addCustomer(c1);
//		service.addCustomer(c2);
//		service.addCustomer(c3);
//	}

//	@AfterEach
//	public void tearDown() {
//		service.deleteCustomer(101);
//		service.deleteCustomer(102);
//		service.deleteCustomer(103);
//	}

	@Test
	void testAddCustomer() {
		Customer c1 = new Customer(105, "Amal", "amalts@gmail.com", LocalDate.parse("1998-10-23"), UserType.GENERAL);

//		when
		Customer savedCustomer = service.addCustomer(c1);
//		then

		assertEquals(c1, savedCustomer);
		assertThrows(CustomerAlreadyExistsException.class, () -> service.addCustomer(c1));
	}

	@Test
	void testGetCustomer() {
		int id = 101;
		int id2 = 108;
		Customer c1 = service.getCustomer(101);
		assertNotNull(c1);

		assertThrows(CustomerNotFoundException.class, () -> service.getCustomer(id2));

	}

	@Test
	void testUpdateCustomer() {
		Customer cus = new Customer(101, "ashna", "amalts@yahoo.com", LocalDate.parse("1998-10-23"), UserType.GENERAL);
		Customer updatedCus = service.updateCustomer(cus);

		assertEquals(cus, updatedCus);
	}

	@Test
	void testDeleteCustomer() {
		int id = 102;
		service.deleteCustomer(id);

		assertThrows(CustomerNotFoundException.class, () -> service.getCustomer(id));
	}

	@Test
	void testGetAllCustomers() {
		List<Customer> list = service.getAllCustomers();
		assertNotEquals(0, list.size());
	}

	@Test
	void testGetCustomerByName() {
		String name = "feril";
		String name2 = "amal";
		Customer c = service.getCustomerByName(name);

		assertNotNull(c);
		assertThrows(CustomerNotFoundException.class, () -> service.getCustomerByName(name2));
	}

	@Test
	void testGetCustomerByEmail() {
		String mail = "feril@gmail.com";
		String mail2 = "amal@gmail.com";
		Customer c = service.getCustomerByEmail(mail);

		assertNotNull(c);
		assertThrows(CustomerNotFoundException.class, () -> service.getCustomerByEmail(mail2));
	}

	@Test
	void testGetCustomerByDob() {
		List<Customer> dobList = service.getCustomerByDob(LocalDate.parse("1996-10-23"), LocalDate.parse("1997-10-23"));
		assertTrue(dobList.size() > 0);
	}

	@Test
	void testGetCustomerByIdRange() {
		List<Customer> idList = service.getCustomerByIdRange(101,102);
		assertTrue(idList.size() > 0);
	}

}
