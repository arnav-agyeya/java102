package com.arn.first.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.arn.first.entities.Employee;
import com.arn.first.repos.EmployeeJpaRepo;


@RestController
@CrossOrigin("*")
@RequestMapping(path="/api/")
public class EmployeeRestController {
	@Autowired
	EmployeeJpaRepo employeeJpaRepo;
	
	@RequestMapping(path="/employee/{id}", method=RequestMethod.GET)
	public Employee findEmployee(@PathVariable("id") int id){
		
		System.out.println("FInd Employee in controller ..." + id);
		Employee emp = employeeJpaRepo.findEmployeeById(id);
		System.out.println(emp);
		return emp;

	}
	
	@RequestMapping (path="/employee",method=RequestMethod.POST)
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp)  {
		
		
		employeeJpaRepo.save(emp);
		System.out.println(emp);
		ResponseEntity<Employee> re = new ResponseEntity<Employee>(emp,HttpStatus.OK);
		return re;
	}
	
	@RequestMapping (path="/employeefind",method=RequestMethod.GET)
	public ArrayList<Employee> findEmployeeByName(@RequestParam("empName") String empName) {
		
		
		return employeeJpaRepo.findEmployeeByName(empName);
		
	}
	
	@RequestMapping (path="/employeeshow",method=RequestMethod.GET)
	public List<Employee> showEmployee() {
		
		System.out.println(employeeJpaRepo.findAll());
		return  employeeJpaRepo.findAll();
		
	}
	
	@RequestMapping(path="/employeedelete/{id}",method=RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable("id") int id) {
		employeeJpaRepo.deleteById(id);
	}

}
