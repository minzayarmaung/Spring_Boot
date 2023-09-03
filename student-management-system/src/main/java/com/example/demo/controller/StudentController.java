package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;


@Controller
public class StudentController {
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	// Handle Method to handle list students and return mode and view
	// Model used to pass DATA to View in SpringBoot
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students",studentService.getAllStudents());
		return "students"; // This "students" return to the students.html
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		
		// Create Student Object to Hold Student Form Data
		Student student = new Student(); 
		model.addAttribute("student",student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") Student student ,Model model) {
		// Get Student from Database by Id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setName(student.getName());
		existingStudent.setParentName(student.getParentName());
		existingStudent.setEmail(student.getEmail());
		
		//Save updated Student Object
		
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
	// Handler Method to Delete Student Request
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
		
	}
}
