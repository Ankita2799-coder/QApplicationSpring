package com.harbourxquizapp.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.harbourxquizapp.model.Role;
import com.harbourxquizapp.model.UserModel;
import com.harbourxquizapp.model.UserRole;
import com.harbourxquizapp.repository.RoleRepository;
import com.harbourxquizapp.repository.UserRepo;
@Service
public class UserServiceImpl {
@Autowired
private UserRepo userRepo;
@Autowired
private RoleRepository roleRepository;
@Autowired
private PasswordEncoder passwordEncoder;
//creating new user
public UserModel createUser(UserModel user ) throws Exception
{
	System.out.println("creating new user role");
	Role role=new Role();
	role.setRoleId(45L);
	role.setRoleName("ROLE_USER");
	user.setPassword(passwordEncoder.encode(user.getPassword()));
//	user.setCpassword(passwordEncoder.encode(user.getCpassword()));
	Set<UserRole> roles=new HashSet<UserRole>();
	UserRole userRole=new UserRole();
	userRole.setRole(role);
	userRole.setUser(user);
	roles.add(userRole);
	System.out.println("inside create user method:: userservice impl");
	UserModel local=this.userRepo.findByUsername(user.getUsername());
	UserModel local1=this.userRepo.findByEmail(user.getUsername());
	if(local!=null || local1!=null)
	{
	throw new Exception("User already present !!");
	}
	else {
		for(UserRole ur:roles)
		{
			roleRepository.save(ur.getRole());
		}
		user.getUserRoles().addAll(roles);
		local=this.userRepo.save(user);
	}
	return local;
}
}
