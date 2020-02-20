package com.statemachine.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.statemachine.constant.StateMachineConstant;
import com.statemachine.dto.CusotmerRequestDto;
import com.statemachine.dto.CusotmersResponseDto;
import com.statemachine.dto.CustomerCreateRequestDto;
import com.statemachine.entity.Customers;
import com.statemachine.exception.CusotmerNotFoundException;
import com.statemachine.exception.CustomerEmailNotFoundException;
import com.statemachine.exception.CustomerMobileNumberNotFoundException;
import com.statemachine.exception.CustomerNameNotFoundException;
import com.statemachine.repository.CustomersRepository;

@Service
public class CustomersServiceImpl implements CustomersService {

	@Autowired
	CustomersRepository customersRepository;

	public CusotmersResponseDto addressChange(CusotmerRequestDto cusotmerRequestDto) throws CusotmerNotFoundException {
		CusotmersResponseDto cusotmersResponseDto = new CusotmersResponseDto();
		Optional<Customers> customerResp = customersRepository.findById(cusotmerRequestDto.getCustomerId());
		if (!customerResp.isPresent()) {
			throw new CusotmerNotFoundException("ORN-001", "Cusotmer not found");
		} else {

		}
		return cusotmersResponseDto;
	}

	@Override
	public CusotmersResponseDto createAccount(CustomerCreateRequestDto customerCreateRequestDto)
			throws CustomerMobileNumberNotFoundException, CustomerEmailNotFoundException,
			CustomerNameNotFoundException {
		if (customerCreateRequestDto.getMobileNumber().equals(null)) {
			throw new CustomerMobileNumberNotFoundException(StateMachineConstant.MOBILE, StateMachineConstant.BAD_REQ);
		}
		if (customerCreateRequestDto.getEmail().equals(null) || customerCreateRequestDto.getEmail().trim().equals("")) {
			throw new CustomerEmailNotFoundException(StateMachineConstant.EMAIL, StateMachineConstant.BAD_REQ);
		}
		if (customerCreateRequestDto.getCustomerName().equals(null)
				|| customerCreateRequestDto.getCustomerName().trim().equalsIgnoreCase("")) {
			throw new CustomerNameNotFoundException(StateMachineConstant.NAME, StateMachineConstant.BAD_REQ);
		}
		CusotmersResponseDto cusotmersResponseDto = new CusotmersResponseDto();
		Customers customers = new Customers();
		Random rand = new Random();
		customers.setAccountNumber(rand.nextLong() + 1000L);
		customers.setAddress(customerCreateRequestDto.getAddress());
		customers.setCustomerName(customerCreateRequestDto.getCustomerName());
		customers.setEmail(customerCreateRequestDto.getEmail());
		customers.setMobileNumber(customerCreateRequestDto.getMobileNumber());
		customers = customersRepository.save(customers);
		cusotmersResponseDto.setCustomersId(customers.getCustomerId());
		return cusotmersResponseDto;
	}
}
