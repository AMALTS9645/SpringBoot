package com.ust.app.customerapp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ust.app.customerapp.exception.CustomerAlreadyExistsException;
import com.ust.app.customerapp.exception.CustomerNotFoundException;
import com.ust.app.customerapp.model.Customer;
import com.ust.app.customerapp.model.UserType;
import com.ust.app.customerapp.repository.CustomerRepo;

@SpringBootTest
//@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class CustomerServiceImplUnitTest {
	
	@Mock
	private CustomerRepo repo;

	@InjectMocks
	private CustomerServiceImpl service;

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
		// Given
				Customer c1 = new Customer(105, "Steve", "steve@yahoo.com", LocalDate.of(2000, 10, 10), UserType.GENERAL);
				Customer c2 = new Customer(105, "John", "john@yahoo.com", LocalDate.of(2000, 10, 10), UserType.GENERAL);

				// When
				when(repo.save(c1)).thenReturn(c1);
				when(repo.save(c2)).thenThrow(CustomerAlreadyExistsException.class);

				// Then
				assertEquals(c1, service.addCustomer(c1));
				assertThrows(CustomerAlreadyExistsException.class, () -> service.addCustomer(c2));

				// Verify whether repo.save() method is called 1 time
				verify(repo, times(1)).save(c1);
				verify(repo, times(1)).save(c2);


		
	}
	

	@Test
	void testGetCustomer() {
		// Given
				int id1 = 101;
				int id2 = 100;
				Customer c1 = new Customer(101, "Steve", "steve@yahoo.com", LocalDate.of(2000, 10, 10), UserType.GENERAL);

				// When
				when(repo.existsById(id1)).thenReturn(true);
				when(repo.existsById(id2)).thenReturn(false);
				when(repo.findById(id1)).thenReturn(Optional.of(c1));
//				when(repo.findById(id2)).thenThrow(CustomerNotFoundException.class);

				// Then
				assertEquals(c1, service.getCustomer(id1));
				assertThrows(CustomerNotFoundException.class, 
										() -> service.getCustomer(id2));

				// Verify whether repo.save() method is called 1 time
				verify(repo,times(1)).existsById(id1);
				verify(repo,times(1)).existsById(id2);
				verify(repo, times(1)).findById(id1);
				// verify(repo, times(1)).findById(id2);
				
	}

	@Test
	void testUpdateCustomer() {
		
		Customer cus = new Customer(101, "ashna", "ashna@yahoo.com", LocalDate.parse("1998-10-23"), UserType.GENERAL);
		Customer c2 = new Customer(106, "John", "john@yahoo.com", LocalDate.parse("2000-10-10"), UserType.GENERAL);
		
		
		when(repo.existsById(101)).thenReturn(true);
		when(repo.existsById(106)).thenReturn(false);
		when(repo.save(cus)).thenReturn(cus);
		lenient().when(repo.save(c2)).thenThrow(CustomerNotFoundException.class);
		
		
		assertEquals(cus, service.updateCustomer(cus));
		assertThrows(CustomerNotFoundException.class, () -> service.updateCustomer(c2));

		verify(repo,times(1)).existsById(101);
		verify(repo,times(1)).existsById(106);
		verify(repo,times(1)).save(cus);
//		verify(repo,times(1)).save(c2);
		
	}

	@Test
	void testDeleteCustomer() {
		
		int id = 102;
		int id2 = 105;
		
		when(repo.existsById(id)).thenReturn(true);
		when(repo.existsById(id2)).thenReturn(false);
		
		
		assertDoesNotThrow(()->service.deleteCustomer(id));
		assertThrows(CustomerNotFoundException.class, ()->service.deleteCustomer(id2));
		
		
		verify(repo,times(1)).deleteById(id);
		verify(repo,times(1)).existsById(id2);
		
	}

	@Test
	void testGetAllCustomers() {
		Customer c1 = new Customer(101, "feril", "feril@gmail.com", LocalDate.parse("1998-10-23"), UserType.GENERAL);
		Customer c2 = new Customer(106, "John", "john@yahoo.com", LocalDate.parse("2000-10-10"), UserType.GENERAL);
		List<Customer> cusList = new ArrayList<>(List.of(c1,c2));
		
		when(repo.findAll()).thenReturn(cusList);
		
		assertEquals(cusList, service.getAllCustomers());
		
		verify(repo,times(1)).findAll();
	}

	@Test
	void testGetCustomerByName() {
		// Given
		String name1 = "steve";
		String name2 = "amal";
		Customer c1 = new Customer(101, "Steve", "steve@yahoo.com", LocalDate.of(2000, 10, 10), UserType.GENERAL);

		// When

		when(repo.findByname(name1)).thenReturn(Optional.of(c1));
		when(repo.findByname(name2)).thenThrow(CustomerNotFoundException.class);

		// Then
		assertEquals(c1, service.getCustomerByName(name1));
		assertThrows(CustomerNotFoundException.class, 
								() -> service.getCustomerByName(name2));

		// Verify whether repo.save() method is called 1 time
		verify(repo, times(1)).findByname(name1);
		verify(repo, times(1)).findByname(name2);
	}

	@Test
	void testGetCustomerByEmail() {
		// Given
		String mail1 = "steve@yahoo.com";
		String mail2 = "amal@gmail.com";
		Customer c1 = new Customer(101, "Steve", "steve@yahoo.com", LocalDate.of(2000, 10, 10), UserType.GENERAL);

		// When

		when(repo.findByemail(mail1)).thenReturn(Optional.of(c1));
		when(repo.findByemail(mail2)).thenThrow(CustomerNotFoundException.class);

		// Then
		assertEquals(c1, service.getCustomerByEmail(mail1));
		assertThrows(CustomerNotFoundException.class, 
								() -> service.getCustomerByEmail(mail2));

		// Verify whether repo.save() method is called 1 time
		verify(repo, times(1)).findByemail(mail1);
		verify(repo, times(1)).findByemail(mail2);
	}

	@Test
	void testGetCustomerByDob() {
		Customer c1 = new Customer(101, "feril", "feril@gmail.com", LocalDate.parse("1998-10-23"), UserType.GENERAL);
		Customer c2 = new Customer(106, "John", "john@yahoo.com", LocalDate.parse("2000-10-23"), UserType.GENERAL);
		List<Customer> cusList = new ArrayList<>(List.of(c1,c2));
		
		
		when(repo.findDobRange(LocalDate.parse("1998-10-23"), LocalDate.parse("2000-10-23"))).thenReturn(cusList);
		
		
		
		assertEquals(cusList, service.getCustomerByDob(LocalDate.parse("1998-10-23"), LocalDate.parse("2000-10-23")));
		
		verify(repo,times(1)).findDobRange(LocalDate.parse("1998-10-23"), LocalDate.parse("2000-10-23"));
	}

	@Test
	void testGetCustomerByIdRange() {
		Customer c1 = new Customer(101, "feril", "feril@gmail.com", LocalDate.parse("1998-10-23"), UserType.GENERAL);
		Customer c2 = new Customer(106, "John", "john@yahoo.com", LocalDate.parse("2000-10-23"), UserType.GENERAL);
		List<Customer> cusList = new ArrayList<>(List.of(c1,c2));
		
		when(repo.findIdRange(100, 107)).thenReturn(cusList);
		
		assertEquals(cusList, service.getCustomerByIdRange(100, 107));
		
		verify(repo,times(1)).findIdRange(100, 107);
	}

}
