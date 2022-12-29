package com.ust.EmplyoeeRegistration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USTEmployee")
public class Employee {
	
     @Id
     @GeneratedValue
	private int empId;
	private String empName;
	private String location;
	private String domain;
	private String emailId;
	private int exp;
	
	
	public Employee(int empId, String empName, String location, String domain, String emailId, int exp) {
		
		this.empId = empId;
		this.empName = empName;
		this.location = location;
		this.domain = domain;
		this.emailId = emailId;
		this.exp = exp;
	}
	
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}



	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
}

