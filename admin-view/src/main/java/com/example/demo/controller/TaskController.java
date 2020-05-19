package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Task;
import com.example.demo.exception.ResourceNotFoundException;

import com.example.demo.repository.TaskRepository;



@RestController 
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {
	
    @Autowired
    private TaskRepository taskRepository; 
    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable(value = "id") Long task_id)
        throws ResourceNotFoundException {
       Task task = taskRepository.findById(task_id)
          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + task_id));
        return ResponseEntity.ok().body(task);
    } 
}
