package com.zayar.practice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name" , nullable = false)
	private String name;
	
	@Column(name = "email" , nullable = false)
	private String email;
	
	@Column(name = "position", nullable = false)
	private String position;
	
	@Column(name = "salary", nullable = false)
	private Integer salary;
	
	public Employee() {
	
	}

	public Employee(String name, String email,String position ,Integer salary) {
		super();
		this.name = name;
		this.email = email;
		this.position=position;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position=position;
	}
	

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	
	
}
