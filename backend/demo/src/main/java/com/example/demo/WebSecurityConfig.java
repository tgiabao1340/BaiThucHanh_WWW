package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.service.UserDetailsServiceImp;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImp();
	};

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.and()
		.logout()
		.permitAll();
	}
	public void configure(WebSecurity web) throws Exception {
		web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/fonts/**", "/bootstrap/***");
	}
}
