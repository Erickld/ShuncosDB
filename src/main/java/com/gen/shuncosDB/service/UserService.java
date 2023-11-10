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

	
	//Peticion para el login de User
	public HashMap<String, Object> loginUser(HashMap<String, String> userJson) {
		HashMap<String, Object> response = new HashMap<String, Object>();
		response.put("userFinded", false);
	    for (User usrx : userRepository.findAll()) {
	        if (usrx.getUsername().equals(userJson.get("username")) && usrx.getPassword().equals(userJson.get("password"))) {
	        	response.put("userFinded", true);
	        	response.put("user", usrx);
	            break;
	        }
		}
	    return response;
	}
	
	
	//Post para crear usuario
	public HashMap<String, Object> createUser(HashMap<String, String> userJson) {
		
		//Validamos si el correo y username del nuevo usuario ya se encuentra registrado por otro usuario
		HashMap<String, Object> response = new HashMap<String, Object>();
		response.put("usernameInUse", false);
		response.put("emailInUse", false);

	    
	    for (User usrx : userRepository.findAll()) {
	        if(usrx.getUsername().equals(userJson.get("username"))) {
	        	response.put("usernameInUse", true);
	            break;
	        }
	        if(usrx.getEmail().equals(userJson.get("email"))) {
	        	response.put("emailInUse", true);
	            break;
	        }
		}
	    
	    if((boolean)response.get("usernameInUse") || (boolean)response.get("emailInUse")) {
	        return response;
	    }

	    //Se crea usuario
		User user = new User();
		user.setFirst_name(userJson.get("first_name"));		
		user.setLast_name(userJson.get("last_name"));
		user.setUsername(userJson.get("username"));
		user.setEmail(userJson.get("email"));
		user.setPassword(userJson.get("password"));
		user.setIs_admin(false);
		userRepository.save(user);
		
		response.put("user", user);
		return response;
	}



	//Put
	public HashMap<String, Object> updateUser(Long id, HashMap<String, String> userJson) {	    
		//Validamos si el correo y username del nuevo usuario ya se encuentra registrado por otro usuario
		HashMap<String, Object> response = new HashMap<String, Object>();
		response.put("usernameInUse", false);
		response.put("emailInUse", false);

		 //&& usr.id !== currentUserx.id
	    for (User usrx : userRepository.findAll()) {
	        if(usrx.getUsername().equals(userJson.get("username")) && usrx.getUser_id() != id) {
	        	response.put("usernameInUse", true);
	            break;
	        }
	        if(usrx.getEmail().equals(userJson.get("email")) && usrx.getUser_id() != id) {
	        	response.put("emailInUse", true);
	            break;
	        }
		}
	    
	    if((boolean)response.get("usernameInUse") || (boolean)response.get("emailInUse")) {
	        return response;
	    }
	    
		User user = userRepository.findById(id).orElse(null);
		user.setFirst_name(userJson.get("first_name"));		
		user.setLast_name(userJson.get("last_name"));
		user.setUsername(userJson.get("username"));
		user.setEmail(userJson.get("email"));
		user.setPassword(userJson.get("password"));
		
		userRepository.save(user);
		response.put("user", user);
		return response;
		
	}
	
	//Delete
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
}