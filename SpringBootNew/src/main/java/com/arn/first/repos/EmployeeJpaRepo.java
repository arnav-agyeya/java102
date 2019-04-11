package com.arn.first.repos;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arn.first.entities.Employee;

public interface EmployeeJpaRepo extends JpaRepository<Employee, Integer>{
	
	//public Employee findEmployeeByName(String name);
	public ArrayList<Employee> findEmployeeByName(String name);
	public Employee findEmployeeById(int id);
	
	@Query("Select e from Employee e")
	public ArrayList<Employee> findEmployees();
	
	public void delete(Employee emp);

}
