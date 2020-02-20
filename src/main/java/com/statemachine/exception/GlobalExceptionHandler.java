package com.statemachine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.statemachine.constant.StateMachineConstant;
import com.statemachine.dto.ResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseDto> noUserDataAvaliableException() {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(StateMachineConstant.INVALID_LOGIN);
		responseDto.setStatusCode(StateMachineConstant.NOTFOUND_CODE);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
	}

	@ExceptionHandler(CusotmerNotFoundException.class)
	public ResponseEntity<ResponseDto> cusotmerNotFoundException() {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(StateMachineConstant.NOTFOUND_CODE);
		responseDto.setStatusCode(StateMachineConstant.NOTFOUND_CODE);
		return ResponseEntity.status(HttpStatus.OK).body(responseDto);
	}

	@ExceptionHandler(CustomerEmailNotFoundException.class)
	public ResponseEntity<ResponseDto> customerEmailNotFoundException() {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(StateMachineConstant.EMAIL);
		responseDto.setStatusCode(StateMachineConstant.BAD_REQ);
		return ResponseEntity.status(HttpStatus.OK).body(responseDto);
	}

	@ExceptionHandler(CustomerMobileNumberNotFoundException.class)
	public ResponseEntity<ResponseDto> customerMobileNumberNotFoundException() {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(StateMachineConstant.MOBILE);
		responseDto.setStatusCode(StateMachineConstant.BAD_REQ);
		return ResponseEntity.status(HttpStatus.OK).body(responseDto);
	}

	@ExceptionHandler(CustomerNameNotFoundException.class)
	public ResponseEntity<ResponseDto> customerNameNotFoundException() {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(StateMachineConstant.NAME);
		responseDto.setStatusCode(StateMachineConstant.BAD_REQ);
		return ResponseEntity.status(HttpStatus.OK).body(responseDto);
	}
}