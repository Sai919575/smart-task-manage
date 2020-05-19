package com.example.demo.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Manager;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ManagerRepository;
@RestController 
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class ManagerController {
	
	    @Autowired
	    private ManagerRepository managerRepository; 
	    @GetMapping("/managers")
	    public List<Manager> getAllManagers() {
	        return managerRepository.findAll();
	    }

	    @GetMapping("/managers/{id}")
	    public ResponseEntity<Manager> getTaskById(@PathVariable(value = "id") Long manager_id)
	        throws ResourceNotFoundException {
	       Manager manager = managerRepository.findById(manager_id)
	          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + manager_id));
	        return ResponseEntity.ok().body(manager);
	    } 
	    @PostMapping("/managers")
	    public Manager createManager(@Valid @RequestBody Manager manager) {
	        return managerRepository.save(manager);
	    }

	    @PutMapping("/managers/{id}")
	    public ResponseEntity<Manager> updateManager(@PathVariable(value = "id") Long manager_id,
	         @Valid @RequestBody Manager managerDetails) throws ResourceNotFoundException {
	        Manager manager = managerRepository.findById(manager_id)
	        .orElseThrow(() -> new ResourceNotFoundException("Manager not found for this id :: " + manager_id));

	        manager.setManager_name(managerDetails.getManager_name());
	      manager.setManager_email(managerDetails.getManager_email());
	        manager.setManager_password(managerDetails.getManager_password());

	        final Manager updatedManager = managerRepository.save(manager);
	        return ResponseEntity.ok(updatedManager);
	    }

	    @DeleteMapping("/managers/{id}")
	    public Map<String, Boolean> deleteManager(@PathVariable(value = "id") Long manager_id)
	         throws ResourceNotFoundException {
	        Manager manager = managerRepository.findById(manager_id)
	       .orElseThrow(() -> new ResourceNotFoundException("Manager not found for this id :: " + manager_id));

	        managerRepository.delete(manager);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
}

