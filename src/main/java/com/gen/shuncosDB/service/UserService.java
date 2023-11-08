package com.gen.shuncosDB.service;

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
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	//Put
	public User updateUser(Long id, User userDetails) {
		User user = userRepository.findById(id).orElse(null);
		
		user.setFirst_name(userDetails.getFirst_name());
		user.setLast_name(userDetails.getLast_name());
		user.setUsername(userDetails.getUsername());
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());
		//user.setIs_admin(userDetails.getIs_admin());
		
		return userRepository.save(user);
		
	}
	
	//Delete
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
}