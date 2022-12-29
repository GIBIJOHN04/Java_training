package com.example.UserDetails.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserDetails.Repos.UserRepos;
import com.example.UserDetails.model.User;



@Service
public class UserService {
	
	@Autowired
	
	private static UserRepos userrepos;
	public static List<User> getUser() {
		return userrepos.findAll();
	}

	public static User getUserByid(Integer id) {
		
		return userrepos.findById(id).orElse(null);
	}

	
	public static User CreateUser(User u) {
		// TODO Auto-generated method stub
		return userrepos.save(u);
	}

	
	public User updateUser(User u) {
		User user =null;
		Optional<User> updateUser =userrepos.findById(u.getId());
		if (updateUser.isPresent()) {
			user.setName(u.getName());
			user.setAddress(u.getAddress());
			user.setField(u.getField());
			user.setDescription(u.getDescription());
			user.setHours(u.getHours());
			user.setCost(u.getCost());
			user.setId(u.getId());
			user.setPhone(u.getPhone());
		}
		else {
			return new User();
		}
		return user;
		
	
	}

	public static String deleteUserByid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
