package com.cts;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



public class CompanyControllerTest {
 
	@Autowired
	EmployeeService employeeService;
	
	@Test
	public void test() {
		
		System.out.println("nnnnn");

		Optional<Employee> found = employeeService.findById(101l);
		System.out.println(found.get());

		assertNotNull(found.get());
	      	
	}

	

}
