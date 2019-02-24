package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Employee;

public interface EmployeeDao {

	Employee findById(int id);
	
	void saveEmployee(Employee employee);
	
	void deleteEmployee(Employee employee);
	
	List<Employee> findAllEmployees();

}
