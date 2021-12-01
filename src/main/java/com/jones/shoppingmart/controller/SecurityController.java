package com.jones.shoppingmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jones.shoppingmart.helper.JwtUtil;
import com.jones.shoppingmart.model.AuthenticationRequestModel;
import com.jones.shoppingmart.model.AuthenticationResponseModel;
import com.jones.shoppingmart.security.MyUserDetailsService;

@RestController
public class SecurityController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	//TO DO : handle authentications
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequestModel authenticationRequestModel) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequestModel.getUsername(),
				authenticationRequestModel.getPassword()));
		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequestModel.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponseModel(jwt) );
	}

}
