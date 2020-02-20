package com.statemachine.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.statemachine.exception.CusotmerNotFoundException;
import com.statemachine.service.CustomersService;

/**
 * This controller used to perform the some events like address change and mobile no change
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

	CustomersService  customersService;
	/**
	 * This method is used to change the address
	 * 
	 * @param cusotmerRequestDto
	 * @return cusotmersResponseDto
	 * @throws CusotmerNotFoundException 
	 */
	@PostMapping("/addresschange")
	public ResponseEntity<CusotmersResponseDto> addressChange(@RequestBody CusotmerRequestDto cusotmerRequestDto) throws CusotmerNotFoundException {
		LOGGER.info(StateMachineConstant.INSIDE_METHOD);
		CusotmersResponseDto cusotmersResponseDto = customersService.addressChange(cusotmerRequestDto);
		cusotmersResponseDto.setMessage(StateMachineConstant.SUCCESS);
		cusotmersResponseDto.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(cusotmersResponseDto, HttpStatus.OK);
	}
}
