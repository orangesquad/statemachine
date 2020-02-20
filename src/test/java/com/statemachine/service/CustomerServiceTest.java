package com.statemachine.service;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.statemachine.dto.CusotmerRequestDto;
import com.statemachine.repository.CustomersRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomerServiceTest {
	
	@InjectMocks
	CustomersServiceImpl customerServiceImpl;
	@Mock
	CustomersRepository customerRepository;
	
	@Test
	public void addressChangeTest()
	{
		CusotmerRequestDto cusotmerRequestDto= new CusotmerRequestDto();
		cusotmerRequestDto.setCustomerId(1L);
		cusotmerRequestDto.setEventDate(LocalDate.now());
		cusotmerRequestDto.setEventName("Change Mobile Number");
		cusotmerRequestDto.setEventType(" ");
		
	}

}
