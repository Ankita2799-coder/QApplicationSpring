package com.tutorialproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tutorialproject.model.UserModel;
import com.tutorialproject.repository.UserRepo;
@Service
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
	UserRepo userrepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user=userrepo.findByUsername(username);
		if(user==null)
		{
			System.out.println("user not found");
			throw new UsernameNotFoundException("user not found"+username);
		}
		return user;
	}

}
