package com.aaslin.employee.service;

import java.util.List;

import com.aaslin.employee.exception.NotFoundException;
import com.aaslin.employee.model.Employee;

public interface employeeService {
	Employee saveEmployee(Employee employee);
	Employee getEmployeeById(int id) throws NotFoundException;
	List<Employee> getAllEmployees();
}
