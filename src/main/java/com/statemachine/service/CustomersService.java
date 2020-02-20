package com.statemachine.service;

import com.statemachine.dto.CusotmerRequestDto;
import com.statemachine.dto.CusotmersResponseDto;
import com.statemachine.exception.AccountNotActiveException;
import com.statemachine.exception.CusotmerNotFoundException;

public interface CustomersService {

	CusotmersResponseDto customerChangeRequest(CusotmerRequestDto cusotmerRequestDto) throws CusotmerNotFoundException, AccountNotActiveException;

}
