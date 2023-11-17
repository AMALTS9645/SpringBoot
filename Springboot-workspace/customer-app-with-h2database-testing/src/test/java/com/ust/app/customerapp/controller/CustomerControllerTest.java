package com.ust.app.customerapp.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ust.app.customerapp.model.Customer;
import com.ust.app.customerapp.model.UserType;
import com.ust.app.customerapp.service.CustomerService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = CustomerController.class)
class CustomerControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	CustomerService service;

	@Test
	void testAddCustomer() throws Exception {
		// Given
				Customer c1 = new Customer(105, "Steve", "steve@yahoo.com", LocalDate.of(2000, 10, 10), UserType.GENERAL);
				// When
				when(service.addCustomer(c1)).thenReturn(c1);

				// Then
				mockMvc.perform(post("/api/customers")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(c1)))
						.andExpect(status().isCreated())
						.andExpect(jsonPath("$.id", Matchers.is(105)))
						.andExpect(jsonPath("$.name", Matchers.is("Steve")))
						.andExpect(jsonPath("$.email", Matchers.is("steve@yahoo.com")))
						.andExpect(jsonPath("$.dob", Matchers.is("2000-10-10")))
						.andExpect(jsonPath("$.type", Matchers.is("GENERAL")));

	}

//	@Test
//	void testGetAllCustomers() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetCustomerById() throws Exception {
		// Given
		Customer c1 = new Customer(105, "Amal", "amal@gmail.com", LocalDate.parse("1997-11-23"), UserType.GENERAL);
		int id = c1.getId();
		// When
		when(service.getCustomer(id)).thenReturn(c1);

		// Then
		mockMvc.perform(get("/api/customers/" + id)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", Matchers.is(105)))
				.andExpect(jsonPath("$.name", Matchers.is("Amal")))
				.andExpect(jsonPath("$.email", Matchers.is("amal@gmail.com")))
				.andExpect(jsonPath("$.type", Matchers.is("GENERAL")))
				.andExpect(jsonPath("$.dob", Matchers.is("1997-11-23")));

	}

//	@Test
//	void testUpdateCustomers() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteCustomer() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetByName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetByEmailString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetByEmailLocalDateLocalDate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetByIdRange() {
//		fail("Not yet implemented");
//	}

	private String asJsonString(Object object) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.writeValueAsString(object);
    }


}
