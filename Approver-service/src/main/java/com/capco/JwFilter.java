package com.capco;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
public class JwFilter extends GenericFilterBean{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) res;
		String header = request.getHeader("Authorization");
		System.out.println("header is "+header);
		if (header == null || !header.startsWith("Bearer")) {
			chain.doFilter(request, res);
			return;
		}

		UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(request, response);
		
	}
	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) throws IllegalArgumentException, UnsupportedEncodingException {
		String token = request.getHeader("Authorization");
		System.out.println("header in username is" + token);
		JWTVerifier verifier=null;
		Algorithm algorithm=null;
		algorithm = Algorithm.HMAC512("shubham");
		verifier = JWT.require(algorithm).acceptExpiresAt(0).build();
		logger.info("decoding token");
		DecodedJWT decodedJWT=verifier.verify(token.replace("Bearer ", ""));
		logger.info(decodedJWT);
		String user=decodedJWT.getSubject();
		logger.info(user);
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		list=decodedJWT.getClaim("roles").asList(String.class).stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		logger.info(list.toString());
		return new UsernamePasswordAuthenticationToken(user, null, list);
	}
}
