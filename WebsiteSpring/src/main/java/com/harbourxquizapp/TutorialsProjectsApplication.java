package com.harbourxquizapp;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.harbourxquizapp.Service.UserServiceImpl;
import com.harbourxquizapp.model.Role;
import com.harbourxquizapp.model.UserModel;
import com.harbourxquizapp.model.UserRole;
import com.harbourxquizapp.repository.UserRepo;

@SpringBootApplication
public class TutorialsProjectsApplication implements CommandLineRunner {
@Autowired
UserServiceImpl userService;
@Autowired
UserRepo userrepo;
	public static void main(String[] args) {
		SpringApplication.run(TutorialsProjectsApplication.class, args);
		
	}
    @Override
	public void run(String[] args) throws Exception
	{
		System.out.println("starting code");
//		UserModel user=new UserModel();
//		user.setName("Devansh Popli");
//		user.setPassword("admin1122");
//		user.setCpassword("admin1122");
//		user.setUsername("admin");
//		user.setEmail("devanshpopli6@gmail.com");
//		user.setPhone("9056624920");
//		Role role1=new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("ROLE_ADMIN");
//		Set<UserRole> userRoleSet=new HashSet<>();
//		UserRole userRole=new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		userRoleSet.add(userRole);
//		if(userrepo.findByEmail(user.getEmail())==null || userrepo.findByUsername(user.getUsername())==null) {
//		UserModel user1=userService.createUser(user);
//		System.out.println(user1.getEmail());
//		}else {
//			System.out.println("admin user exists");
//		}
	}
}
