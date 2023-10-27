package com.sb.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.formation.entities.User;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.UserServiceImpl;
import com.sb.formation.service.UserServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@GetMapping
    @PreAuthorize("hasRole('ADMIN')")
	public List<User> findAll() {
		return userService.findAll();
	}

	@PostMapping
    @PreAuthorize("hasRole('ADMIN')")
	public MessageResponse save(@RequestBody User user) {
		return userService.save(user);
	}

	@PutMapping
    @PreAuthorize("hasRole('ADMIN')")
	public MessageResponse update(@RequestBody User user) {
		return userService.update(user);
	}

	@GetMapping("/{code}")
    @PreAuthorize("hasRole('ADMIN')")
	public User findById(@PathVariable("code") Long id) {
		return userService.findById(id);
	}

	@DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
	public MessageResponse delete(@PathVariable Long id) {
		return userService.delete(id);
	}
}
