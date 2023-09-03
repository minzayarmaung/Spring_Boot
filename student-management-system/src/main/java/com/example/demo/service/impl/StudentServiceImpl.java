package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service	
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;

	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	// Update and get Student By Id
	@Override
	public Student getStudentById(Long Id) {
		return studentRepository.findById(Id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	// Delete Student by Id
	@Override
	public void deleteStudentById(Long Id) {
		studentRepository.deleteById(Id);
	}

	
	
}
