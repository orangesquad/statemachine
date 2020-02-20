package com.statemachine.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCreateRequestDto {
	private String customerName;
	private Long mobileNumber;
	private String email;
	private String address;
	
}
