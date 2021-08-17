package com.tutorialproject.Service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorialproject.model.UserModel;
import com.tutorialproject.model.UserRole;
import com.tutorialproject.repository.RoleRepository;
import com.tutorialproject.repository.UserRepo;
@Service
public class UserServiceImpl {
@Autowired
private UserRepo userRepo;
@Autowired
private RoleRepository roleRepository;
//creating new user
public UserModel createUser(UserModel user,Set<UserRole> userRoles ) throws Exception
{
	System.out.println("inside create user method:: userservice impl");
	UserModel local=this.userRepo.findByUsername(user.getUsername());
	if(local!=null)
	{
	throw new Exception("User already present !!");
	}
	else {
		for(UserRole ur:userRoles)
		{
			roleRepository.save(ur.getRole());
		}
		user.getUserRoles().addAll(userRoles);
		local=this.userRepo.save(user);
	}
	return local;
}
}
