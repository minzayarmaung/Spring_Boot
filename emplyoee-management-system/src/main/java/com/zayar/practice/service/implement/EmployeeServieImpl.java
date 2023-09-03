package com.zayar.practice.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zayar.practice.entity.Employee;
import com.zayar.practice.repository.EmployeeRepository;
import com.zayar.practice.service.EmployeeService;

@Service
public class EmployeeServieImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	public EmployeeServieImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	// Get and Save Employee
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	// **********************************************************************
	
	// DELETE Employee
	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
		
	}
	// ************************************************************************
	

	// Get and Update Employee
	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> searchEmployees(String query) {
	    return employeeRepository.findByNameContainingIgnoreCase(query);
	}


}
