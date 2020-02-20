package com.statemachine.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statemachine.dto.CusotmerRequestDto;
import com.statemachine.dto.CusotmersResponseDto;
import com.statemachine.entity.Customers;
import com.statemachine.exception.CusotmerNotFoundException;
import com.statemachine.repository.CustomersRepository;
@Service
public class  CustomersServiceImpl implements CustomersService{

	@Autowired
	CustomersRepository customersRepository;
	
	public CusotmersResponseDto addressChange(CusotmerRequestDto cusotmerRequestDto) throws CusotmerNotFoundException {
		CusotmersResponseDto cusotmersResponseDto=new CusotmersResponseDto();
		Optional<Customers> customerResp = customersRepository.findById(cusotmerRequestDto.getCustomerId());
		if(!customerResp.isPresent()) {
			throw new CusotmerNotFoundException("ORN-001","Cusotmer not found");
		}else {
			
		}
		
		return cusotmersResponseDto;
	}
}
