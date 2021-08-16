package com.harbourxquizapp.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.harbourxquizapp.Service.UserDetailsServiceImp;

import io.jsonwebtoken.ExpiredJwtException;
@Component
public class jwtAuthenticationFilter extends OncePerRequestFilter{
	@Autowired 
	private UserDetailsServiceImp userDetailsService;
	@Autowired 
	private JwtUtil jwtUtil;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
		final String authorizationHeader=request.getHeader("Authorization");
//		If you want information from SecurityContextHolder, you have to keep it on there.
//
//		Here is the easiest solution for this:
//
//		Get Auth Token from the request, where your current log user info present.
//		Extract log user name from jwt using some Util method.
//		Get the user details from the Database using this user name.
//		Finally Set this User info into the Spring Security context holder.
//		And you have to do this every Request Using an HTTP Request Filter (OncePerRequestFilter).
//Security context is the place that keeps the record of currently logged in user also known as principal
		//Security context holder is the helper class which provides access to the security context
		String username=null;
		String jwt=null;
		if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer "))
		{
			jwt=authorizationHeader.substring(7);
			username=jwtUtil.extractUsername(jwt);
		}
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UserDetails userDetails=this.userDetailsService.loadUserByUsername(username);
			//need userDetails and jwt for validating jwt
			if(jwtUtil.validateToken(jwt, userDetails)) {
				//we are telling spring to continue the flow
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);		
			}
		}
		} catch (BadCredentialsException ex) {
			request.setAttribute("exception", ex);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		filterChain.doFilter(request, response);
		
	}



}
