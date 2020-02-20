package com.statemachine.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statemachine.constant.StateMachineConstant;
import com.statemachine.dto.CusotmerRequestDto;
import com.statemachine.dto.CusotmersResponseDto;
import com.statemachine.entity.Customers;
import com.statemachine.entity.Events;
import com.statemachine.exception.AccountNotActiveException;
import com.statemachine.exception.CusotmerNotFoundException;
import com.statemachine.repository.CustomersRepository;
import com.statemachine.repository.EventsRepository;

@Service
public class CustomersServiceImpl implements CustomersService {

	@Autowired
	CustomersRepository customersRepository;
	@Autowired
	EventsRepository eventsRepository;

	public CusotmersResponseDto customerChangeRequest(CusotmerRequestDto cusotmerRequestDto)
			throws CusotmerNotFoundException, AccountNotActiveException {
		CusotmersResponseDto cusotmersResponseDto = new CusotmersResponseDto();
		Optional<Customers> customerResp = customersRepository.findById(cusotmerRequestDto.getCustomerId());
		if (!customerResp.isPresent()) {
			throw new CusotmerNotFoundException(StateMachineConstant.ORN_001, StateMachineConstant.NOT_FOUND_CODE);
		} else if (customerResp.get().getState().equalsIgnoreCase(StateMachineConstant.NOTACTIVE)) {
			throw new AccountNotActiveException(StateMachineConstant.ORN_002, StateMachineConstant.NOT_ACTIVE);			
		} else {
			String state = customerResp.get().getState();
			String eventName = cusotmerRequestDto.getEventName();
			
		}

		return cusotmersResponseDto;
	}
}
