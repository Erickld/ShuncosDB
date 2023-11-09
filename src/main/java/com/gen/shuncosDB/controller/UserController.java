package com.gen.shuncosDB.controller;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.gen.shuncosDB.model.User;
import com.gen.shuncosDB.service.UserService;


@RestController
@CrossOrigin
@RequestMapping("/shuncos/user")
public class UserController {
	private final UserService userService;
    //Relaciones
    //private GenreService genreService;
    //private AuthorService authorService;
	
	@Autowired
    public UserController(UserService userService) {
		this.userService = userService;
	}
	
	// GET all users
    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }


    // GET a single user by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
    	User user =userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST a new user
    @PostMapping
    public User createUser(@RequestBody HashMap<String, String> userJson) {
        return userService.createUser(userJson);
    }

    // PUT to update a user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody HashMap<String, String> userJson) {
    	User updatedUsuario = userService.updateUser(id, userJson);
        if (updatedUsuario != null) {
            return ResponseEntity.ok(updatedUsuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE a book
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    	User Usuario = userService.getUserById(id);
        if (Usuario != null) {
        	userService.deleteUser(id);
            return ResponseEntity.ok().<Void>build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
