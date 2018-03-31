package com.capco;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.capco.enities.AppUser;
import com.capco.utils.SecurityConstants;

public class SecurityUtils {
	

	public static String generateToken(AppUser user) {
		/*return Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET.getBytes())
				.compact();*/
		Claims claims = Jwts.claims().setSubject(user.getUsername());
		List<String> rolesList=new ArrayList<>();
		if(user.getUsername()!=null) {
			String[] roles=user.getRoles().split(",");
			for(String s:roles) {
				rolesList.add(s);
			}
			claims.put("roles",rolesList);
		}
		String token = Jwts.builder()
				.setClaims(claims)
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512,SecurityConstants.SECRET.getBytes())
				.compact();
		return token;
	}
}