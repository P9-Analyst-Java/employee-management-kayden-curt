package com.deloitte.ms.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.deloitte.ms.entity.LoginUser;
import com.deloitte.ms.repo.LoginUserRepo;

@Service
public class LoginUserService implements UserDetailsService {

	@Autowired
	private LoginUserRepo loginUserRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		LoginUser existingUser = loginUserRepo.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("user not found"));

		return new org.springframework.security.core.userdetails.User(existingUser.getEmail(), existingUser.getPassword(), new ArrayList<>());
	}

}
