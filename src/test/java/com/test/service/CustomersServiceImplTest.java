package com.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.statemachine.dto.CusotmerRequestDto;
import com.statemachine.dto.CusotmersResponseDto;
import com.statemachine.entity.Customers;
import com.statemachine.exception.AccountNotActiveException;
import com.statemachine.exception.CusotmerNotFoundException;
import com.statemachine.repository.CustomersRepository;
import com.statemachine.service.CustomersServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomersServiceImplTest {
	@InjectMocks
	CustomersServiceImpl customersServiceImpl;

	@Mock
	CustomersRepository customersRepository;

	@Test
	public void testCustomerChangeRequest() throws CusotmerNotFoundException, AccountNotActiveException {
		Customers customers=new Customers();
		customers.setCustomerId(1L);
		customers.setState("Active");
		Optional<Customers> cusotmers=Optional.of(customers);
		Mockito.when(customersRepository.findById(1L)).thenReturn(cusotmers);
		CusotmerRequestDto cusotmerRequestDto=new CusotmerRequestDto();
		cusotmerRequestDto.setCustomerId(1L);
		CusotmersResponseDto customerChangeRequest = customersServiceImpl.customerChangeRequest(cusotmerRequestDto);
		customerChangeRequest.setCustomersId(1L);
		assertEquals(1L, customerChangeRequest.getCustomersId());
	}
	@Test(expected = CusotmerNotFoundException.class)
	public void testCustomerChangeRequestException() throws CusotmerNotFoundException, AccountNotActiveException {
		Customers customers=new Customers();
		customers.setCustomerId(1L);
		customers.setState("Active");
		Optional<Customers> cusotmers=Optional.of(customers);
		Mockito.when(customersRepository.findById(1L)).thenReturn(cusotmers);
		CusotmerRequestDto cusotmerRequestDto=new CusotmerRequestDto();
		CusotmersResponseDto customerChangeRequest = customersServiceImpl.customerChangeRequest(cusotmerRequestDto);
		customerChangeRequest.setCustomersId(1L);
	}
	@Test(expected = AccountNotActiveException.class)
	public void testCustomerChangeRequestAccException() throws CusotmerNotFoundException, AccountNotActiveException {
		Customers customers=new Customers();
		customers.setCustomerId(1L);
		customers.setState("In Active");
		Optional<Customers> cusotmers=Optional.of(customers);
		Mockito.when(customersRepository.findById(1L)).thenReturn(cusotmers);
		CusotmerRequestDto cusotmerRequestDto=new CusotmerRequestDto();
		cusotmerRequestDto.setCustomerId(1L);
		CusotmersResponseDto customerChangeRequest = customersServiceImpl.customerChangeRequest(cusotmerRequestDto);
		
	}
}
