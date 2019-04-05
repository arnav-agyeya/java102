package com.sapient.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
@Entity
public class Email {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String email;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "E_Id")
	Employee employee;
	
	public Email(String email) {
		this.email=email;
	}
	
}
