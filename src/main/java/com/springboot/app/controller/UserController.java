package com.springboot.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.springboot.app.dao.UserRepository;
import com.springboot.app.model.User;



	@CrossOrigin(origins="http://localhost:4200")
	@RestController
	@RequestMapping("/data")


	public class UserController {
		
		

	    @Autowired
	    private UserRepository repository;
	   
	    @GetMapping("/")
		public String login(){
			return "authenticated successfully" ;
		}
	    
	    
	    
	     @PostMapping("/register")
	    public String register(@RequestBody User user) {
	        repository.save(user);
	        return "Hi " + user.getName() + " your Registration process successfully completed";
	    }
	    
	    @GetMapping("/getAllUsers")
	    public List<User> findAllUsers() {
	        return repository.findAll();
	    }

	    @GetMapping("/form/{id}")
	    public Optional<User> getUserById(@PathVariable(value = "id") long id)
	        {
	    return repository.findById(id);
	    }
	   
	    @PostMapping("/form")
		public User doRegistration(@Validated @RequestBody User user) {
			return repository.save(user);
		}	
	    

	    @DeleteMapping("/cancel/{id}")
	    public List<User> cancelRegistration(@PathVariable Long id) {
	        repository.deleteById(id);
	        return repository.findAll();
	    }
	    
	    @PutMapping("/form/{id}")
	    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long id,
				@Validated @RequestBody User userDetails) throws ResourceNotFoundException {
			User user = repository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException());

			user.setEmail(userDetails.getEmail());
			user.setName(userDetails.getName());
			user.setPhoneno(userDetails.getPhoneno());
			user.setSalary(userDetails.getSalary());
			user.setDob(userDetails.getDob());

			final User updatedUser = repository.save(user);
			return ResponseEntity.ok(updatedUser);
		}
		}
	    

	   
	   
	

