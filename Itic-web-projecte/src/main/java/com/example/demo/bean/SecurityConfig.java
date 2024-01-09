package com.example.demo.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig{
	
	@Bean
	public AuthenticationManager AuthManager(HttpSecurity http, PasswordEncoder password, UserDetailsService userDetailsService)throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDetailsService)
				.passwordEncoder(password)
				.and().build();
	}	
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
		
		http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		
		http.authorizeHttpRequests()
				.mvcMatchers("/auth/**").permitAll()
				.anyRequest()
				.authenticated();
		
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		var userDetailsService = new InMemoryUserDetailsManager();
		
		
		UserDetails userAdmin = User.builder()
				.username("admin")
				.password(this.passwordEncoder().encode("1234"))
				.authorities("read")
				.build();
		
		UserDetails userStandard = User.builder().username("user1").password(this.passwordEncoder().encode("1234")).authorities("read").build();
		
		userDetailsService.createUser(userAdmin);
		userDetailsService.createUser(userStandard);
	
	
		UserDetails userAdminItamar = User.builder()
				.username("Itamar")
				.password(this.passwordEncoder().encode("1234"))
				.authorities("read")
				.build();
		
		UserDetails userAdminLuis = User.builder()
				.username("Luis")
				.password(this.passwordEncoder().encode("1234"))
				.authorities("read")
				.build();
		
		UserDetails userAdminOscar = User.builder()
				.username("Oscar")
				.password(this.passwordEncoder().encode("1234"))
				.authorities("read")
				.build();
		
		
		
		userDetailsService.createUser(userAdminItamar);
		userDetailsService.createUser(userAdminLuis);
		userDetailsService.createUser(userAdminOscar);

		return userDetailsService;
	}
		
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

