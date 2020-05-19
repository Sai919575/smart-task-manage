package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long task_id;
	
	private String task_name;
	
	private String task_description;
	
	private boolean task_status;
	

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Task(Long task_id, String task_name, String task_description, boolean task_status) {
		super();
		this.task_id = task_id;
		this.task_name = task_name;
		this.task_description = task_description;
		this.task_status = task_status;
	}
	
	
	
	
	

	@Override
	public String toString() {
		return "Task [task_id=" + task_id + ", task_name=" + task_name + ", task_description=" + task_description
				+ ", task_status=" + task_status + "]";
	}




	public Long getTask_id() {
		return task_id;
	}

	public void setTask_id(Long task_id) {
		this.task_id = task_id;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public String getTask_description() {
		return task_description;
	}

	public void setTask_description(String task_description) {
		this.task_description = task_description;
	}

	public boolean isTask_status() {
		return task_status;
	}

	public void setTask_status(boolean task_status) {
		this.task_status = task_status;
	}
	
	
	

}
