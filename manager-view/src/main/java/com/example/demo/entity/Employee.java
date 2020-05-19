package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employee_id;
	
	private String employee_name;
	
	private String employee_password;

	
	private String employee_email;
	
	
	
	
	public String getEmployee_email() {
		return employee_email;
	}

	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}

	public Long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_password() {
		return employee_password;
	}

	public void setEmployee_password(String employee_password) {
		this.employee_password = employee_password;
	}

	

	public Employee(Long employee_id, String employee_name, String employee_password, String employee_email) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_password = employee_password;
		this.employee_email = employee_email;
	}

	
	
	

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", employee_password="
				+ employee_password + ", employee_email=" + employee_email + "]";
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

