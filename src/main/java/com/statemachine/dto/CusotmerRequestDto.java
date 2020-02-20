package com.statemachine.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.statemachine.constant.StateMachineConstant;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class CusotmerRequestDto {
	@NotBlank(message=StateMachineConstant.CUSTOMER_ID_REQUIRED)
	private Long customerId;
	@NotBlank(message=StateMachineConstant.EVENT_NAME_REQUIRED)
	private String eventName;
	@NotBlank(message=StateMachineConstant.EVENT_DATE_REQUIRED)
	private LocalDate eventDate;
	private String eventType;
	private String eventvalue;
}
