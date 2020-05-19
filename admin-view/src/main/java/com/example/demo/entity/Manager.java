package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Manager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long manager_id;
	
	private String manager_name;
	
	private String manager_password;

	
	
	private String manager_email;
	
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	





	public Manager(Long manager_id, String manager_name, String manager_password, String manager_email) {
		super();
		this.manager_id = manager_id;
		this.manager_name = manager_name;
		this.manager_password = manager_password;
		this.manager_email = manager_email;
	}







	public String getManager_email() {
		return manager_email;
	}

	public void setManager_email(String manager_email) {
		this.manager_email = manager_email;
	}

	public Long getManager_id() {
		return manager_id;
	}

	public void setManager_id(Long manager_id) {
		this.manager_id = manager_id;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

	public String getManager_password() {
		return manager_password;
	}

	

	public void setManager_password(String manager_password) {
		this.manager_password = manager_password;
	}


	

	@Override
	public String toString() {
		return "Manager [manager_id=" + manager_id + ", manager_name=" + manager_name + ", manager_password="
				+ manager_password + ", manager_email=" + manager_email + "]";
	}


	
	
	

}
