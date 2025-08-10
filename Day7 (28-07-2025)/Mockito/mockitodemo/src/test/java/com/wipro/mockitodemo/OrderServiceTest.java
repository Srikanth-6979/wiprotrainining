package com.wipro.mockitodemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class OrderServiceTest {

	@Test
	void testPlaceOrderWithMock() {
  
        OrderService mockOrderService = mock(OrderService.class);

        when(mockOrderService.placeOrder("ORD-01")).thenReturn("successful");

        String str = mockOrderService.placeOrder("ORD-01");

        assertEquals("successful", str);

        verify(mockOrderService).placeOrder("ORD-01");
	}

}
