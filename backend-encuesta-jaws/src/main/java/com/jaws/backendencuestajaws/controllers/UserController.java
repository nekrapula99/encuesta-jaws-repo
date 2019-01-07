package com.jaws.backendencuestajaws.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaws.backendencuestajaws.entities.User;
import com.jaws.backendencuestajaws.repositories.UserRepository;

@RestController
@CrossOrigin
@RequestMapping("/encuesta")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping(value="users", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getUsers(){
		System.out.println("Metod getUsers");
		return userRepository.findAll();
	}
	
//	@GetMapping("/user/{id}")
//	public User getUser(@PathVariable int id){
//		return userRepository.findById(id);
//	}
//	
//	@DeleteMapping("/user/{id}")
//	public boolean deleteUser(@PathVariable int id){
//		userRepository.delete(id);
//		return true;
//	}
	
	@PostMapping(value="user", produces = MediaType.APPLICATION_JSON_VALUE)
	public User createUser(@RequestBody User user){
		return userRepository.save(user);
	}
	
	@PutMapping(value="user", produces = MediaType.APPLICATION_JSON_VALUE)
	public User updateUser(@RequestBody User user){
		return userRepository.save(user);
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
}
