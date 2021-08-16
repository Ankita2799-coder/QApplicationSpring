package com.tutorialproject.controller;

import java.security.Principal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tutorialproject.Service.UserDetailsServiceImp;
import com.tutorialproject.model.UserModel;
import com.tutorialproject.model.passswordVO;
import com.tutorialproject.repository.UserRepo;

@RestController
@CrossOrigin(origins = "*")

public class UserController {
	
	@Autowired
	UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	 UserDetailsServiceImp UserDetailsService;
	@Transactional
	@PutMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody UserModel model)
	{
		System.out.println(model.getUsername() + model.getEmail() + model.getName() + model.getPhone());
		userRepo.update(model.getName(), model.getPhone(), model.getEmail(), model.getUsername());
		return new ResponseEntity(200,HttpStatus.OK);
	}
	@Transactional
	@PutMapping("/updatePassword")
	public ResponseEntity<?> updatePassword(@RequestBody passswordVO model)
	{
		System.out.println(model.getPassword()+model.getOldpassword());
		UserModel um=userRepo.findByUsername(model.getUsername());
		if(um.getPassword().equals(model.getOldpassword()))
		{
		userRepo.updatePassword(passwordEncoder.encode(model.getPassword()), model.getUsername());
		return new ResponseEntity(200,HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
	}
	@GetMapping("/current-user")
	public UserModel getCurrentLoginedUser(Principal principal)
	{
		return (UserModel)UserDetailsService.loadUserByUsername(principal.getName());
	}

}
