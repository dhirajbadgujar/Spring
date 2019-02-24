package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Employee;


public interface EmployeeService {

	Employee findById(int id);
	
	void saveEmployee(Employee employee);
	
	void updateEmployee(Employee employee);
	
	void deleteEmployee(Employee employee);
	
	List<Employee> findAllEmployees();
	
}
