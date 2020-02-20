package com.statemachine.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Events {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long eventsId;
	private String eventName;
	private Long eventDate;
}
