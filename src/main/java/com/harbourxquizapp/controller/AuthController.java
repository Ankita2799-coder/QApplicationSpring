package com.harbourxquizapp.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.harbourxquizapp.Service.UserDetailsServiceImp;
import com.harbourxquizapp.Service.UserServiceImpl;
import com.harbourxquizapp.configuration.JwtUtil;
import com.harbourxquizapp.model.JwtRequest;
import com.harbourxquizapp.model.JwtResponse;
import com.harbourxquizapp.model.UserModel;
import com.harbourxquizapp.repository.UserRepo;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class AuthController {
	@Autowired
	 UserRepo userRepo;	
	@Autowired
	 AuthenticationManager authenticationManager;
	@Autowired
	 UserDetailsServiceImp UserDetailsService;
	@Autowired
	 UserServiceImpl userServiceImpl;
	@Autowired
	private JwtUtil jwtTokenUtil;
  

    @RequestMapping(value="/test", method = { RequestMethod.GET })
 	public String getTest() throws Exception {
   
    	return "welcome to core tech tutorial";
 	}
    @RequestMapping(value="/login", method = { RequestMethod.POST })
 	public ResponseEntity<?> getUser(@RequestBody JwtRequest authenticationRequest) throws Exception {
    	 System.out.println("email"+authenticationRequest.getEmail()+"Password"+authenticationRequest.getPassword());
    	 //Authentication Happens here
    	 try {
    	System.out.println("authentication started");
    	 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
    	 System.out.println("authenticatiion performed successfully");
    	 }
    	 catch(BadCredentialsException e)
    	 {
    		 System.out.println(e.getMessage());
    		 return new ResponseEntity<>(authenticationRequest,HttpStatus.INTERNAL_SERVER_ERROR);
    	 }
    	 catch(Exception e)
    	 {
    		 System.out.println(e.getMessage());
    		 return new ResponseEntity<>(authenticationRequest,HttpStatus.INTERNAL_SERVER_ERROR);
    	 }
    	 //Creation of jwt
    	 System.out.println("creation of jwt");
    	 final UserDetails userDetails=UserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
    	 System.out.println("fetched userdetails");
    	 final String jwt=jwtTokenUtil.generateToken(userDetails);
    	 System.out.println("token generated"+jwt);
    	 // returning jwt
    	 return ResponseEntity.ok(new JwtResponse(jwt));
 	}
	
	@PostMapping("register")
	public ResponseEntity<?> signUser(@RequestBody UserModel umodel){
		System.out.println(umodel.toString());
		//check existing user
		UserModel um=userRepo.findByEmail(umodel.getEmail());
		if(um == null)
		{
				try {
			UserModel saveduser=userServiceImpl.createUser(umodel);
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
					 return new ResponseEntity<Object>(500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			 return new ResponseEntity<Object>(202, HttpStatus.OK);
			}
		else
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email already Exists");
		}
		
	}
	
	

}
