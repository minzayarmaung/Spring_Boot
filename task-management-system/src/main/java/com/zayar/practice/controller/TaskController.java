package com.zayar.practice.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zayar.practice.entity.Task;
import com.zayar.practice.service.TaskService;

@Controller
public class TaskController {

	private TaskService taskService;

	public TaskController(TaskService taskService) {
		super();
		this.taskService = taskService;
	}
	
	@GetMapping("/home")
	public String goHome() {
		return "home";
	}
//	@GetMapping("/tasks")
//	public String goTasks() {
//		return "tasks";
//	}
//	
	
	// Get all The Tasks
	@GetMapping("/tasks")
	public String getAllTasks(Model model) {
		model.addAttribute("tasks" , taskService.getAllTasks());
		return "tasks";
	}
	
	// Create Task 
	@GetMapping("/tasks/new")
	public String createTask(Model model) {
		Task task = new Task();
		model.addAttribute("tasks" , task);
		return "create_task";
	}
	
	// Saving Task
	@PostMapping("/tasks")
	public String saveTasks(@ModelAttribute("task") Task task) {
			taskService.saveTask(task);
			return "redirect:/tasks"; 
	}
	
	//Deleteing Task
	@GetMapping("/tasks/{id}")
	public String deleteTask(@PathVariable Long id) {
		taskService.deleteTask(id);
		return "redirect:/tasks";
	}
	
	// Getting Task Info
	@GetMapping("/tasks/edit/{id}")
	public String getTask(@PathVariable Long id , Model model) {
		model.addAttribute("task" , taskService.getbyId(id)); // ( attribute name , argument)
		return "edit_task";
	}
	
	//Updating Task 
	
	@PostMapping("/tasks/{id}")
	public String updateTask(@PathVariable Long id , 
			@ModelAttribute("task") Task task , Model model) {
		
		Task existingTask = taskService.getbyId(id);
		existingTask.setTitle(task.getTitle());
		existingTask.setDescription(task.getDescription());
		existingTask.setCreateDate(task.getCreateDate());
		
		taskService.updateTask(existingTask);
		
		return "redirect:/tasks";
	}
	
	@GetMapping("/tasks/search")
	public String searchTasks(@RequestParam("q") String query , Model model) {
		List<Task> searchResults = taskService.searchTasks(query);
		model.addAttribute("tasks", searchResults);
		return "tasks";
	}
	
}
