package com.ust.EmplyoeeRegistration.comtroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.EmplyoeeRegistration.model.Employee;
import com.ust.EmplyoeeRegistration.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService ;
	
	@PostMapping(value ="/register")
	public Employee addEmployee(@RequestBody Employee emp) {
		return employeeService.CreateEmployee(emp);
	}

	@GetMapping("/UST/Employee")
	public List<Employee> getAllEmployees(){
		return employeeService.getEmployee();
		
	}
	
	@GetMapping("/UST/Employee/{id}")
	public Employee getEmployeeByid(@PathVariable Integer id) {
		return employeeService.getEmployeeByid(id);
		
	}
	
	@PutMapping("/update/employee")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return employeeService.updateEmployee(emp);
	}
	
	@DeleteMapping("/delete/employee/{Id}")
	public String deleteEmployeeByid(@PathVariable Integer id) {
		return employeeService.deleteEmployeeByid(id);
	}
	
	}
