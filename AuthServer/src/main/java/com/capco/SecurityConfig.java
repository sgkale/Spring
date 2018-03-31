package com.capco;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled=true)
public class SecurityConfig {
	private static final Logger logger = Logger.getLogger(SecurityConfig.class);

	// generate token and register user
	@Configuration
	@Order(1)
	public class BasicAuthonfig extends WebSecurityConfigurerAdapter{

		private UserDetailsService userDetailsService;	

		public BasicAuthonfig(UserDetailsService userDetailsService) {
			this.userDetailsService = userDetailsService;
		}

		protected void configure(HttpSecurity http) throws Exception {
			logger.info("websecurity : configure : ");
			http.cors().and().csrf().disable().
			authorizeRequests()
			.antMatchers("/user/sign-up").permitAll()
			.antMatchers(HttpMethod.POST, "/login").permitAll()
			.anyRequest().authenticated() 
			.and()
			.addFilter(new JWTAuthenticationFilter(authenticationManager()))
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			logger.info("websecurity : configure : end configure http security" );
		}

		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			logger.info("websecurity : configure : authentication builder");
			auth.userDetailsService(userDetailsService);
			logger.info("websecurity : configure : authentication builder end");
		}
	}

}
