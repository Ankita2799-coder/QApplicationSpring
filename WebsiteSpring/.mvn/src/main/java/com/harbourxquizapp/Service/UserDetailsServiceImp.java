package com.harbourxquizapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.harbourxquizapp.model.UserModel;
import com.harbourxquizapp.repository.UserRepo;
@Service
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
	UserRepo userrepo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserModel user=userrepo.findByEmail(email);
		if(user==null)
		{
			System.out.println("user not found");
			throw new UsernameNotFoundException("user not found"+email);
		}
		return user;
	}

}
