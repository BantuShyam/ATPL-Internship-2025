package com.aaslin.employee.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaslin.employee.exception.NotFoundException;
import com.aaslin.employee.model.Employee;
import com.aaslin.employee.service.employeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController2 {
	
	private final employeeService service;
	public EmployeeController2(employeeService service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return service.saveEmployee(employee); 
	}
	

	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable int id) throws NotFoundException {
	return service.getEmployeeById(id);
	}
	
	
	@GetMapping
	public List<Employee> employeesList(){
		return service.getAllEmployees();
	}
	
	

}
