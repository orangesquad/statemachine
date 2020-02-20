package com.statemachine.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class CusotmersResponseDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private Integer statusCode;
	private Long customersId;
}
