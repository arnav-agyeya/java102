package com.myapp.java8;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Testlambda {

	public static void main(String[] args) {
		List <Customer> list= Arrays.asList(
				new Customer(1,"Name1",45),
				new Customer(4,"Name2",65),
				new Customer(2,"Name3",32),
				new Customer(3,"Name4",25)
				);
		
//		set.stream().filter(o->o.getOrderprice()>5000.00)
//		.forEach(System.out::println);
		
		
		
		System.out.println((list.stream().filter(o->o.getAge()>30 )).mapToInt( o-> o.getAge()).average());
	}

}
