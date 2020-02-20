package com.statemachine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.statemachine.constant.StateMachineConstant;
import com.statemachine.dto.ResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(CusotmerNotFoundException.class)
	public ResponseEntity<ResponseDto> cusotmerNotFoundException() {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(StateMachineConstant.NOT_FOUND_CODE);
		responseDto.setStatusCode(StateMachineConstant.ORN_001);
		return ResponseEntity.status(HttpStatus.OK).body(responseDto);
	}
	@ExceptionHandler(AccountNotActiveException.class)
	public ResponseEntity<ResponseDto> accountNotActiveException() {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(StateMachineConstant.NOT_ACTIVE);
		responseDto.setStatusCode(StateMachineConstant.ORN_002);
		return ResponseEntity.status(HttpStatus.OK).body(responseDto);
	}
}