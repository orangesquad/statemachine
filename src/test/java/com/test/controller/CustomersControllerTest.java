package com.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.statemachine.controller.CustomersController;
import com.statemachine.dto.CusotmerRequestDto;
import com.statemachine.dto.CusotmersResponseDto;
import com.statemachine.exception.AccountNotActiveException;
import com.statemachine.exception.CusotmerNotFoundException;
import com.statemachine.service.CustomersService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomersControllerTest {
	@InjectMocks
	CustomersController customersController;

	@Mock
	CustomersService customersService;
	
	@Test
	public void testCustomerChangeRequest() throws CusotmerNotFoundException, AccountNotActiveException {
		
		CusotmerRequestDto cusotmerRequestDto=new CusotmerRequestDto();
		cusotmerRequestDto.setCustomerId(1L);
		CusotmersResponseDto customersresponseDto=new CusotmersResponseDto();
		customersresponseDto.setStatusCode(200);
		Mockito.when(customersService.customerChangeRequest(cusotmerRequestDto)).thenReturn(customersresponseDto);
		ResponseEntity<CusotmersResponseDto> customerChangeRequest = customersController.customerChangeRequest(cusotmerRequestDto);
		assertEquals(200,customerChangeRequest.getBody().getStatusCode());
	}
}
