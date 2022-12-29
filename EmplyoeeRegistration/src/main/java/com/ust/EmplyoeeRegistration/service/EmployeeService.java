package com.ust.EmplyoeeRegistration.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.EmplyoeeRegistration.Repostory.EmployeeRepost;

import com.ust.EmplyoeeRegistration.model.Employee;

@Service

public class EmployeeService {
	
	@Autowired 
	private EmployeeRepost employeerepost ;

	public Employee CreateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return employeerepost.save(emp);
	}

	public List<Employee> getEmployee() {
		
		return employeerepost.findAll();
	}

	public Employee getEmployeeByid(Integer id) {
		
		return employeerepost.findById(id).orElse(null);
	}



	public Employee updateEmployee(Employee emp) {
		Employee employee =null;
		Optional<Employee> updateEmployee =employeerepost.findById(emp.getEmpId());
		if (updateEmployee.isPresent()) {
			employee.setDomain(emp.getDomain());
			employee.setEmailId(emp.getEmailId());
			employee.setEmpName(emp.getEmpName());
			employee.setExp(emp.getExp());
			employee.setLocation(emp.getLocation());
			employee.setEmpId(emp.getEmpId());
		}
		else {
			return new Employee();
		}
		return employee;
		
	
	}

	public String deleteEmployeeByid(Integer id) {
		
		employeerepost.deleteById(id);
		return "Employee deleted sucessfully";
	}

}
