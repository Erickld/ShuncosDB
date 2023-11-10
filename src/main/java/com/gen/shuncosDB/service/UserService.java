package com.gen.shuncosDB.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gen.shuncosDB.model.User;
import com.gen.shuncosDB.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	//Get all products
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

	//Get
	public User getUserById(Long id){
		return userRepository.findById(id).orElse(null);
	}

	//Post
	public User createUser(HashMap<String, String> userJson) {
		User user = new User();
		user.setFirst_name(userJson.get("first_name"));		
		user.setLast_name(userJson.get("last_name"));
		user.setUsername(userJson.get("username"));
		user.setEmail(userJson.get("email"));
		user.setPassword(userJson.get("password"));
		user.setIs_admin(false);
		return userRepository.save(user);
	}
	
	//Put
	public User updateUser(Long id, HashMap<String, String> userJson) {
		User user = userRepository.findById(id).orElse(null);
		user.setFirst_name(userJson.get("first_name"));		
		user.setLast_name(userJson.get("last_name"));
		user.setUsername(userJson.get("username"));
		user.setEmail(userJson.get("email"));
		user.setPassword(userJson.get("password"));
		
		return userRepository.save(user);
		
	}
	
	//Delete
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
}