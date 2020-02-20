package com.statemachine.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class CusotmerRequestDto {
	private Long customerId;
	private String eventName;
	private LocalDate eventDate;
	private String eventType;
}
