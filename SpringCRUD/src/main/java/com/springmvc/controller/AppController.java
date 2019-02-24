package com.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.model.Employee;
import com.springmvc.service.EmployeeService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(value = {"/list"}, method = RequestMethod.GET)
	public String listAllEmployees(ModelMap modelMap) {
		List<Employee> empList = employeeService.findAllEmployees();
		modelMap.addAttribute("employeeList", empList);
		return "employeelist";
	}
	
	//TO DO - Try to change method as POST and try
	@RequestMapping(value = {"/new"} , method = RequestMethod.GET)
	public String newEmployee(ModelMap modelMap) {
		Employee employee = new Employee();
		modelMap.addAttribute("employee", employee);
		return "registration";
	}
	
	@RequestMapping(value= {"/new"}, method=RequestMethod.POST)
	public String saveEmployee(@Valid Employee employee, BindingResult result, ModelMap modelMap) {
		if(result.hasErrors()) {
			return "registration";	
		} else {
			employeeService.saveEmployee(employee);
			modelMap.addAttribute("success", "Employee" + employee.getName() + " registered successfully..");
			return "success";
		}
	}
	
	@RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.GET)
	public String editEmployee(@Valid Employee employee, BindingResult result, @PathVariable int id, ModelMap modelMap) {
		if(result.hasErrors()) {
			return "registration";
		} else {
			employeeService.updateEmployee(employee);
			modelMap.addAttribute("success", "Employee "+ employee.getName() + "updated successfully..");
			return "success";
		}
	}
	
	@RequestMapping(value = {"/delete/{id}"}, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable int id, ModelMap modelMap) {
		Employee employee = new Employee();
		employee.setId(id);
		employeeService.deleteEmployee(employee);
		modelMap.addAttribute("success", "Employee with id " + employee.getId() + "is successfully deleted..");
		return "success";
	}
}
