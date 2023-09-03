package com.zayar.practice.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zayar.practice.entity.Employee;
import com.zayar.practice.service.EmployeeService;

@Controller
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	// Handle Method to handle list students and return mode and view
	// Model used to pass DATA to View in SpringBoot

	//Get all the Employees
	@GetMapping("/employees") // Model = pass data from your Java code to your web page
	public String listEmployees(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployee()); // employees = the one match in html
		return "employees"; 
	}
	
	//Create the Employee
	@GetMapping("/employees/new")
	public String createEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "add_emp";
	}
	
	// Display the Employees
	@PostMapping("/employees")
	public String saveEmployees(@ModelAttribute("employee") Employee employee ) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
		
	}
	// Delete the Employee
	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}

	
	// Update and Get Employees
	@GetMapping("/employees/edit/{id}")
	public String editEmployeeForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee",employeeService.getEmployeeById(id));
		return "update_employee";
	}
	
	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable Long id , 
			@ModelAttribute("employee") Employee employee , Model model) {
		Employee existingEmployee = employeeService.getEmployeeById(id);
		existingEmployee.setName(employee.getName());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setSalary(employee.getSalary());
		existingEmployee.setPosition(employee.getPosition());
		
		employeeService.updateEmployee(existingEmployee);
		
		return "redirect:/employees";
	}
	@GetMapping("/employees/search")
	public String searchEmployees(@RequestParam("q") String query, Model model) {
	    List<Employee> searchResults = employeeService.searchEmployees(query);
	    model.addAttribute("employees", searchResults);
	    return "employees";
	}

	
}
