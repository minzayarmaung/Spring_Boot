package com.zayar.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zayar.practice.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	
	List<Task>findByTitleIgnoreCase(String name);
}
