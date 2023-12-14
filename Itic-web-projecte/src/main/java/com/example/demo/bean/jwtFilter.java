package com.example.demo.bean;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class jwtFilter extends OncePerRequestFilter {
//Dejado en minuto 32:22
	
	
	@Autowired
	private JwtTokenProvider tokenProvider; 
	@Autowired
	private UserDetailsService userService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		
		String token = this.extractToken(request);
		
		if (this.tokenProvider.isValidToken(token)) {
			
			String username = this.tokenProvider.getUsernameFromToken(token);
	
			UserDetails user = this.userService.loadUserByUsername(username);
			org.springframework.security.core.Authentication auth = new UsernamePasswordAuthenticationToken(user.getUsername(),
					user.getPassword(),
					user.getAuthorities());
	
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		
		filterChain.doFilter(request, response);
		
	}
	
	private String extractToken(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if(StringUtils.hasLength(bearerToken) && bearerToken.startsWith("Bearer")) {
			return bearerToken.substring("Bearer ".length());
		}
		return null;
	}

}
