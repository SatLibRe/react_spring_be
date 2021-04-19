package com.example.codeengine.expense.controller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.codeengine.expense.model.User;
import com.example.codeengine.expense.repository.UserRepository;
import java.net.URI;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	ResponseEntity<?> getUser(@PathVariable Long id){
		Optional<User> user = userRepository.findById(id);
		return user.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("/users/{id}")
	ResponseEntity<?> deleteUser(@PathVariable Long id){
		userRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/users")
	ResponseEntity<User> createExpense(@Validated @RequestBody User user) throws URISyntaxException{
		User result = userRepository.save(user);
		return ResponseEntity.created(new URI("/api/users/" + result.getId())).body(result);
	}
	
	@PutMapping("/users/{id}")
	ResponseEntity<User> updateUser(@Validated @RequestBody User user){
		User result = userRepository.save(user);
		return ResponseEntity.ok().body(result);
	}


}


