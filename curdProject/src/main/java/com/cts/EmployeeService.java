package com.cts;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
	@Autowired
	EmployeeRepository employeeRepository;

	
	public Optional<Employee> findById(Long id) {
		System.out.print(employeeRepository.findById(id));;
		return employeeRepository.findById(id);
	}

	public  Employee save(Employee employee) {	
		return employeeRepository.save(employee);
	}

	public void deleteById(Long id) {
		employeeRepository.deleteById(id);
	}

	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

	

}
