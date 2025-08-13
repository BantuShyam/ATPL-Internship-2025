package com.aaslin.employee.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.aaslin.employee.exception.NotFoundException;
import com.aaslin.employee.model.Employee;

@Service
public class EmployeeServiceImpl implements employeeService{

	private Map<Integer,Employee> employeeDetails=new HashMap<>();
	private int idCount=1;
	@Override
	public Employee saveEmployee(Employee employee) {
		employee.setId(idCount++);
		employeeDetails.put(employee.getId(), employee);
		return employee;
	}
	@Override
	public Employee getEmployeeById(int id) throws NotFoundException {
		Employee emp=employeeDetails.get(id);
		if(emp==null) {
			throw new NotFoundException("Employee with id "+id+" not found");
		}
		return emp;
	}
	@Override
	public List<Employee> getAllEmployees() {
		return new ArrayList<>(employeeDetails.values());
	}
	
}
