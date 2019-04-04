package com.airline.entity;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Flights {
	private int flightNumber;
	private String source,destination;
	private int fare;
	private int time;
	private Airlines airlineName;
	
	
	
}
