package com.zayar.practice.entity;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title" , nullable = false)
	private String title;
	
	@Column(name = "description" , nullable = false)
	private String description;
	
	@Column(name = "createDate" , nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;
	
	public Task() {
		
	}

	public Task(String title, String description, Date createDate) {
		super();
		this.title = title;
		this.description = description;
		this.createDate=createDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
	    return createDate;
	}

	public void setCreateDate(Date createDate) {
	    this.createDate = createDate;
	}

	
}
