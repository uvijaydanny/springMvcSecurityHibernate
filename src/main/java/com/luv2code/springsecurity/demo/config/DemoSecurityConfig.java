package com.luv2code.springsecurity.demo.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 
		/*// add users for in memory authentication
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(users.username("danny").password("test123").roles("EMPLOYEE"))
		.withUser(users.username("vijay").password("test123").roles("MANAGER","EMPLOYEE"))
		.withUser(users.username("admin").password("test123").roles("ADMIN","EMPLOYEE"));*/
		
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			
		http.authorizeRequests().
		antMatchers("/resources/**","/resources/css/**", "/resources/img/**").permitAll()
		.antMatchers("/register/**").permitAll()
		.antMatchers("/intrPanel/candList","/intrPanel/addReview").hasAnyRole("MANAGER", "HR", "PANEL","ADMIN")
		.antMatchers("/reqJobPos").hasAnyRole("MANAGER", "HR", "PANEL", "EMPLOYEE","ADMIN")
		.antMatchers("/create").hasAnyRole("MANAGER", "HR", "EMPLOYEE","ADMIN")
		.antMatchers("/approver/editjob").hasAnyRole("MANAGER", "HR","ADMIN")
		.antMatchers("/finmgmt/editjob").hasAnyRole("FINANCE", "MANAGEMENT","ADMIN")
		.antMatchers("/","/listJobReq").hasAnyRole("EMPLOYEE")
		.antMatchers("/**").hasRole("ADMIN")
		.and().formLogin().loginPage("/loginPage")
		.loginProcessingUrl("/authenticateTheUser").permitAll()
		.and().logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/accessDenied");
	}

	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().
		antMatchers("/").hasRole("EMPLOYEE")
		.antMatchers("/leaders/**").hasRole("MANAGER")
		.antMatchers("/systems/**").hasRole("ADMIN")
		.and().formLogin().loginPage("/loginPage")
		.loginProcessingUrl("/authenticateTheUser").permitAll()
		.and().logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/accessDenied");
	}*/
}
