package com.zayar.practice.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zayar.practice.entity.Task;
import com.zayar.practice.repository.TaskRepository;
import com.zayar.practice.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	
	private TaskRepository taskRepository;
	
	public TaskServiceImpl(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}

	@Override
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	@Override
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}

	@Override
	public Task getbyId(Long id) {
		return taskRepository.findById(id).get();
	}

	@Override
	public Task updateTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public List<Task> searchTasks(String query) {
		return taskRepository.findByTitleIgnoreCase(query);
	}


}
