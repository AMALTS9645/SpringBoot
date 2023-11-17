package com.ust.app;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AppUnitTest {

	@Mock
	AppService service;

	@InjectMocks
	App app;

	@Test
	void testCheck() {
		when(service.check(10)).thenReturn(true);
		when(service.check(5)).thenReturn(false);

		assertTrue(app.check(10));
		assertFalse(app.check(5));

		verify(service, times(1)).check(10);
		verify(service, times(1)).check(5);
	}

	@Test
	void testGetLength() {
		when(service.getLength("Amal")).thenReturn(4);
		
		int len = service.getLength("Amal");
		assertEquals(4, len);
		
		verify(service,times(1)).getLength("Amal");
		
	}

}
