package com.zayar.practice.service;

import java.util.List;

import com.zayar.practice.entity.Employee;

public interface EmployeeService {
	
	//Get Employees
	List<Employee>getAllEmployee();
	
	//Add and Save Employee
	Employee saveEmployee(Employee employee);
	
	// DELETE THE EMPLOYEE
	void deleteEmployeeById(Long id); // void because you don't need to return any values
	
	//Update and Get Employee
	Employee getEmployeeById(Long id);
	
	Employee updateEmployee(Employee employee); 
	
	//Search the Employee
	List<Employee> searchEmployees(String query);

	
}
