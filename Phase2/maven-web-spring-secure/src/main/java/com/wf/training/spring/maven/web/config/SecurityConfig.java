package com.wf.training.spring.maven.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	// configure the credential 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 1. in-memory auth : create hard-coded user (credential)
		// 2. jdbcauthentication : database authentication
		// 3. ldap-server : remote config
		
		// in-memory auth
		// create User
		UserBuilder builder = User.withDefaultPasswordEncoder();
		// register that we want to use in-memory auth
		auth.inMemoryAuthentication()
			.withUser(builder.username("First").password("abc").roles("STUDENT"))
			.withUser(builder.username("Second").password("abc").roles("MENTOR"));
	}
	
	// configure the rules
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// spring security auto maintains sessions
		http.authorizeRequests()  // start defining rule
			.antMatchers("/student/**").hasRole("STUDENT")
			.antMatchers("/mentor/**").hasRole("MENTOR")
			.anyRequest() // every url is secured
			.authenticated()
		.and() // how auth should take place
			// .httpBasic();
			.formLogin() // form based auth
			.loginPage("/custom-login") // url of custom login page/handler : custom login form auth
			.loginProcessingUrl("/validate")  // in-built handler will be provided (free of cost)
			.permitAll()
		.and()
			.logout().permitAll() // inbuilt handler method (by default url /logout)
		.and()
			.exceptionHandling()
				.accessDeniedPage("/access-denied"); // custom access denied page/handler
			
	}
}











