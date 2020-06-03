package com.cts;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

@RestController
@RequestMapping("employee")
public class CompanyController {
	
    @Autowired
	EmployeeService employeeService;
    @Autowired
   	CompanyRepository companyRepository;
    
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll() {
       
    	List<Employee> list = employeeService.getAllEmployees();
    	return new ResponseEntity<List<Employee>>(list, HttpStatus.OK); 
    }
    
    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Employee Employee) {
        return ResponseEntity.ok(employeeService.save(Employee));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable(name = "id") Long id) {	
       Optional<Employee> employee = employeeService.findById(id);
       List<Company> companies = companyRepository.findAllByEmployeeId(id);
       employee.get().setCompany(companies);
        return ResponseEntity.ok(employee.get());
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> update( @Valid @RequestBody Employee employee) { 	
    	
    	Optional<Employee> employee1 = employeeService.findById(employee.getEmployeeId()); 	
        if (employee != null) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {	
    	employeeService.deleteById(id);
        return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
    }

}
