package com.zayar.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zayar.practice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	List<Employee> findByNameContainingIgnoreCase(String name);

}
