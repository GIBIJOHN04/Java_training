package com.example.UserDetails.controller;

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

import com.example.UserDetails.Service.UserService;
import com.example.UserDetails.model.User;


@RestController
@RequestMapping("api/user")
public class UserController {
	@Autowired
	private UserService  userService ;
	
	@PostMapping(value ="/register")
	public User addUser(@RequestBody User u) {
		return UserService.CreateUser(u);
	}

	@GetMapping("/Userdetails")
	public List<User> getAllUser(){
		return UserService.getUser();
		
	}
	
	@GetMapping("/user{id}")
	public User getUserByid(@PathVariable Integer id) {
		return UserService.getUserByid(id);
		
	}
	
	@PutMapping("/update/user")
	public User updateUser(@RequestBody User u) {
		return userService.updateUser(u);
	}
	
	@DeleteMapping("/delete/employee/{Id}")
	public String deleteUserByid(@PathVariable Integer id) {
		return UserService.deleteUserByid(id);
	}
	
	

}
