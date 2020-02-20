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

import com.statemachine.dto.LoginDto;
import com.statemachine.dto.LoginResponseDto;
import com.statemachine.exception.UserNotFoundException;

/**
 * 
 * @author 
 * @version 1.0
 * @since 17-02-2020
 */
@RestController
@RequestMapping("/customers")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class CustomersController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomersController.class);

	/**
	 * This method is used to validating the user by providing the input as LoginDto
	 * 
	 * @param loginDto
	 * @return responseDTO
	 * @throws UserNotFoundException 
	 */
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> usersLogin(@RequestBody LoginDto loginDto) throws UserNotFoundException{
		LOGGER.info("Inside UserController :: userLogin.");
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
	}

}
