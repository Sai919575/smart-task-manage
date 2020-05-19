package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeRepository;


@RestController 
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

	    @Autowired
	    private EmployeeRepository employeeRepository; 
	    @GetMapping("/employees")
	    public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }

	    @GetMapping("/employees/{id}")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employee_id)
	        throws ResourceNotFoundException {
	       Employee employee = employeeRepository.findById(employee_id)
	          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employee_id));
	        return ResponseEntity.ok().body(employee);
	    } 
	    @PostMapping("/employees")
	    public Employee createEmployee(@Valid @RequestBody Employee employee) {
	        return employeeRepository.save(employee);
	    }

	    @PutMapping("/employees/{id}")
	    public ResponseEntity<Employee> updateManager(@PathVariable(value = "id") Long employee_id,
	         @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
	        Employee employee = employeeRepository.findById(employee_id)
	        .orElseThrow(() -> new ResourceNotFoundException("Manager not found for this id :: " + employee_id));

	        employee.setEmployee_name(employeeDetails.getEmployee_name());
	        employee.setEmployee_email(employeeDetails.getEmployee_email());
	        employee.setEmployee_password(employeeDetails.getEmployee_password());

	        final Employee updatedEmployee = employeeRepository.save(employee);
	        return ResponseEntity.ok(updatedEmployee);
	    }

	    @DeleteMapping("/employees/{id}")
	    public Map<String, Boolean> deleteManager(@PathVariable(value = "id") Long employee_id)
	         throws ResourceNotFoundException {
	    	Employee employee = employeeRepository.findById(employee_id)
	       .orElseThrow(() -> new ResourceNotFoundException("Manager not found for this id :: " + employee_id));

	    	employeeRepository.delete(employee);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
}

