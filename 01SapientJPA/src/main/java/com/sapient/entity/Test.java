package com.sapient.entity;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		
		Address homeAddress = new Address(234, "GK", "Delhi");
		Address officeAddress = new Address(234, "Marthalli", "Bangalore");
		
		Employee emp = new Employee("Priya", 34343.33);
		
		// Set Employee into Adresses
		homeAddress.setEmployee(emp);
		officeAddress.setEmployee(emp);
		
		Email email = new Email("xyz@abc.com");
		Email email1 = new Email("abc@def.com");
		email.setEmployee(emp);
		email1.setEmployee(emp);
		
		List<Address> addresses = new ArrayList<>();
		addresses.add(homeAddress);
		addresses.add(officeAddress);
		
		List<Email> emails = new ArrayList<>();
		emails.add(email);
		emails.add(email1);
		
		// Set Addresses into Employee
		emp.setAddresses(addresses);
		emp.setEmails(emails);
		dao.addEmployee(emp);
		
//		dao.addAddress(homeAddress);
//		dao.addAddress(officeAddress);
		
	
//		
//		Employee e = dao.findEmployee(9);
//		System.out.println(e);
		
//		List<Employee> emps = dao.findAllEmployee();
//		System.out.println(emps);
		
//		System.out.println( dao.findAllEmployeByName("Priya"));

	}

}
