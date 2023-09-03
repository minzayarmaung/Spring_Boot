package com.zayar.practice.service;

import java.util.List;

import com.zayar.practice.entity.Task;

public interface TaskService {
	
	// Get all Tasks
	List<Task>getAllTasks();
	
	// Save Task
	Task saveTask(Task task);
	
	//Delete Task
	void deleteTask(Long id);
	
	// Get Employee by Id
	Task getbyId(Long id);
	
	//Update Task 
	Task updateTask(Task task);
	
	//Search Task
	List<Task> searchTasks(String query);
	
}
