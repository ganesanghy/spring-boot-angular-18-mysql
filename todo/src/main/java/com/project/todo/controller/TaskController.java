package com.project.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.todo.model.Task;
import com.project.todo.repo.TaskRepo;

@RestController
@CrossOrigin
@RequestMapping("/api/task")
public class TaskController {
	
	@Autowired
	private TaskRepo taskRepo;
	
	@GetMapping("hello")
	public String helloWorld() {
		return "hello-world";
	}
	
	@PostMapping
	public Task getTask(@RequestBody Task task) {
		return taskRepo.save(task);
	}
	
	@GetMapping
	public List<Task> getAllTask(){
		return taskRepo.findAll();
	}
	
	@PutMapping("/{id}")
	public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
		task.setId(id);
		return taskRepo.save(task);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {
		taskRepo.deleteById(id);
	}
}
