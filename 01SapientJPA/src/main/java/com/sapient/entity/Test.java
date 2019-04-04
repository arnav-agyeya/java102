package com.sapient.entity;

public class Test {

	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		
		Employee emp = new Employee("Priya", 34043.33);
		
		//dao.addEmployee(emp);
		dao.updateEmployee(3, 10000);
//		Employee e = dao.findEmployee(3);
//		System.out.println(e);
		
	}

}
