package com.capco.service;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.capco.enities.AppUser;
import com.capco.repository.UserRepo;

import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserDetailsImpl implements UserDetailsService{
	private static final Logger logger = Logger.getLogger(UserDetailsImpl.class);
	@Autowired
	UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("UserDetailsImpl : load by username:start");
		AppUser user = repo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		String[] roles=user.getRoles().split(",");
		for(String s:roles) {
			list.add(new SimpleGrantedAuthority(s));
		}
		logger.info("UserDetailsImpl : load by username:end " + user.getUsername());
		return  new User(user.getUsername(), user.getPassword(),list);
	}

}
