package com.capco;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled=true)
public class SecurityConfig {
	
	
	@Configuration
	@Order(1)
	public class TokenAuthonfig extends WebSecurityConfigurerAdapter{
		private UserDetailsService userDetailsService;
		
		public TokenAuthonfig(UserDetailsService userDetailsService) {
			this.userDetailsService = userDetailsService;
		}

		protected void configure(HttpSecurity http) throws Exception {
			http.cors().and().csrf().disable().
			authorizeRequests()
			.anyRequest().authenticated() 
			.and()
			.addFilterBefore(new JwFilter(), UsernamePasswordAuthenticationFilter.class)
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		}	
	
	}
	
	

}
