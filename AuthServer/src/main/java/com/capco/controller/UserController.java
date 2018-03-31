package com.capco.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.capco.utils.SecurityConstants.*;

import com.capco.SecurityUtils;
import com.capco.enities.AppUser;
import com.capco.repository.UserRepo;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	@GetMapping
	@RequestMapping(value="/test")
	public String test() {
		return "test";
	}	
	
	@PostMapping
	@RequestMapping(value="/sign-up")
	public String signUp(@RequestBody AppUser user, HttpServletResponse response){
		user.setPassword(user.getPassword());
		repo.save(user);
		String token=SecurityUtils.generateToken(user);
		response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + token);
		return user.getUsername()+""+token;
	}

}
