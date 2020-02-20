package com.statemachine.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.statemachine.constant.StateMachineConstant;
import com.statemachine.dto.CusotmerRequestDto;
import com.statemachine.dto.CusotmersResponseDto;
import com.statemachine.dto.CustomerCreateRequestDto;
import com.statemachine.exception.AccountNotActiveException;
import com.statemachine.exception.AccountNumberNotFoundException;
import com.statemachine.exception.AddressNotFoundException;
import com.statemachine.exception.CusotmerNotFoundException;
import com.statemachine.exception.CustomerEmailNotFoundException;
import com.statemachine.exception.CustomerMobileNumberNotFoundException;
import com.statemachine.exception.CustomerNameNotFoundException;
import com.statemachine.service.CustomersService;

/**
 * This controller used to perform the some events like address change and
 * mobile no change
 * 
 * @author Rajesh
 * @version 1.0
 * @since 17-02-2020
 */
@RestController
@RequestMapping("/customers")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class CustomersController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomersController.class);
	@Autowired
	CustomersService customersService;
	/**
	 * This method is used to update the state of customer of perticular event by  current state
	 * 
	 * @param cusotmerRequestDto
	 * @return cusotmersResponseDto
	 * @throws CusotmerNotFoundException 
	 * @throws AccountNotActiveException 
	 */
	@PostMapping("/changerequest")
	public ResponseEntity<CusotmersResponseDto> customerChangeRequest(@Valid@RequestBody CusotmerRequestDto cusotmerRequestDto) throws CusotmerNotFoundException, AccountNotActiveException {
		LOGGER.info(StateMachineConstant.INSIDE_METHOD);
		CusotmersResponseDto cusotmersResponseDto = customersService.customerChangeRequest(cusotmerRequestDto);
		cusotmersResponseDto.setMessage(StateMachineConstant.SUCCESS);
		cusotmersResponseDto.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(cusotmersResponseDto, HttpStatus.OK);
	}
	/**
	 * This method is used to create the account
	 * 
	 * @author Shankar
	 * @version 1.0
	 * @since 17-02-2020
	 */
	@PostMapping("/createAccount")
	public ResponseEntity<CusotmersResponseDto> createAccount(@RequestBody CustomerCreateRequestDto customerCreateRequestDto)
			throws AccountNumberNotFoundException, CustomerMobileNumberNotFoundException,
			CustomerEmailNotFoundException, CustomerNameNotFoundException, AddressNotFoundException {
		LOGGER.info("User Create Account ");
		CusotmersResponseDto cusotmersResponseDto = customersService.createAccount(customerCreateRequestDto);
		cusotmersResponseDto.setMessage("Success");
		cusotmersResponseDto.setStatusCode(200);
		return new ResponseEntity<>(cusotmersResponseDto, HttpStatus.OK);
	}

}
