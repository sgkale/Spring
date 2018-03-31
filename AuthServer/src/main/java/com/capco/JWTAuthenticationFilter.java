package com.capco;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.capco.enities.AppUser;
import com.capco.repository.UserRepo;
import com.capco.utils.SecurityConstants;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Configurable
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	private static final Logger logger = Logger.getLogger(JWTAuthenticationFilter.class);
	private AuthenticationManager authenticationManager;



	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;

	}

	@Autowired
	UserRepo repo;

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req,
			HttpServletResponse res) throws AuthenticationException {
		try {
			AppUser creds = new ObjectMapper()
					.readValue(req.getInputStream(), AppUser.class);
			//User u=repo.findByUsername(creds.getUsername());
			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							creds.getUsername(),
							creds.getPassword(),
							new ArrayList<>())
					);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	protected void successfulAuthentication(HttpServletRequest req,
			HttpServletResponse res,
			FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		String username = ((User) auth.getPrincipal()).getUsername();
		System.out.println("princial name="+username+((User) auth.getPrincipal()).getAuthorities().toString()  );
		Claims claims = Jwts.claims().setSubject(username);
		List<String> rolesList=new ArrayList<>();
		if(username!=null) {
			Collection<GrantedAuthority> roles=((User) auth.getPrincipal()).getAuthorities();
			Iterator<GrantedAuthority> itr=roles.iterator();
			while(itr.hasNext()) {
				rolesList.add(itr.next().toString());
			}
			claims.put("roles",rolesList);
		}


		String token = Jwts.builder()
				.setClaims(claims)
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512,SecurityConstants.SECRET.getBytes())
				.compact();
		res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + " " + token);
	}


}
