package com.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.rest.model.User;
import com.rest.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	private UserService usService;
	
	@GetMapping
	public String index() {
		return "<h1>Servizio User</h1>";
	}
	
	@GetMapping("/all")
	public List<User> all() {
		return usService.getUsers();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable(value = "id") Long userId)
		throws Exception {
			User us = usService.getUser(userId);
			return ResponseEntity.ok().body(us);
	}
	@DeleteMapping("/user/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
		throws Exception {
			Map<String, Boolean> response = new HashMap<>();
			boolean test = usService.deleteUser(userId);
			response.put("deleted", test);
			return response;
	}
	@PostMapping("/user")
	public User createUser(@Validated @RequestBody User user) {
		usService.saveUser(user);
		return user;
		}
	
}
