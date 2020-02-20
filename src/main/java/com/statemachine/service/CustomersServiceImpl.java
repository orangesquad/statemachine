package com.statemachine.service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.statemachine.constant.StateMachineConstant;
import com.statemachine.dto.CusotmerRequestDto;
import com.statemachine.dto.CusotmersResponseDto;
import com.statemachine.dto.CustomerCreateRequestDto;
import com.statemachine.entity.Customers;
import com.statemachine.entity.Events;
import com.statemachine.exception.AccountNotActiveException;
import com.statemachine.exception.AddressNotFoundException;
import com.statemachine.exception.CusotmerNotFoundException;
import com.statemachine.exception.CustomerEmailNotFoundException;
import com.statemachine.exception.CustomerMobileNumberNotFoundException;
import com.statemachine.exception.CustomerNameNotFoundException;
import com.statemachine.repository.CustomersRepository;

import com.statemachine.repository.EventsRepository;


/**
 * @author Shankar class is used to create the account
 *   
 */
@Service
public class CustomersServiceImpl implements CustomersService {

	@Autowired
	CustomersRepository customersRepository;
	@Autowired
	EventsRepository eventsRepository;
	

	/**
	 * @author Shankar Method is used to check whether the user is valid or not
	 * @param CustomerCreateRequestDto.
	 * @return CusotmersResponseDto.
	 * @throws CustomerMobileNumberNotFoundException
	 * @throws CustomerEmailNotFoundException
	 * @throws CustomerNameNotFoundException
	 * @throws AddressNotFoundException
	 */

	@Override
	public CusotmersResponseDto createAccount(CustomerCreateRequestDto customerCreateRequestDto)
			throws CustomerMobileNumberNotFoundException, CustomerEmailNotFoundException,
			CustomerNameNotFoundException, AddressNotFoundException {
		if (customerCreateRequestDto.getMobileNumber().equals(0)) {
			throw new CustomerMobileNumberNotFoundException(StateMachineConstant.MOBILE, StateMachineConstant.BAD_REQ);
		}
		if (customerCreateRequestDto.getEmail().equals(null) || customerCreateRequestDto.getEmail().trim().equals("")) {
			throw new CustomerEmailNotFoundException(StateMachineConstant.EMAIL, StateMachineConstant.BAD_REQ);
		}
		if (customerCreateRequestDto.getCustomerName().equals(null)
				|| customerCreateRequestDto.getCustomerName().trim().equalsIgnoreCase("")) {
			throw new CustomerNameNotFoundException(StateMachineConstant.NAME, StateMachineConstant.BAD_REQ);
		}
		if (customerCreateRequestDto.getAddress().equals(null)||customerCreateRequestDto.getAddress().trim().equals("")) {
			throw new AddressNotFoundException(StateMachineConstant.ADDRESS, StateMachineConstant.BAD_REQ);
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

	
	public CusotmersResponseDto customerChangeRequest(CusotmerRequestDto cusotmerRequestDto)
			throws CusotmerNotFoundException, AccountNotActiveException {
		CusotmersResponseDto cusotmersResponseDto = new CusotmersResponseDto();
		Optional<Customers> customerResp = customersRepository.findById(cusotmerRequestDto.getCustomerId());
		if (!customerResp.isPresent()) {
			throw new CusotmerNotFoundException(StateMachineConstant.ORN_001, StateMachineConstant.NOT_FOUND_CODE);
		} else if (customerResp.get().getState().equalsIgnoreCase(StateMachineConstant.NOTACTIVE)) {
			throw new AccountNotActiveException(StateMachineConstant.ORN_002, StateMachineConstant.NOT_ACTIVE);
		} else {
		}
		return cusotmersResponseDto;
	}
}
