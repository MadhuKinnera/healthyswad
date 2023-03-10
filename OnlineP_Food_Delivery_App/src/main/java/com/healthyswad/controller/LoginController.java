package com.healthyswad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthyswad.dto.LoginDTO;
import com.healthyswad.exception.LoginException;
import com.healthyswad.service.LoginService;


@RestController
public class LoginController {

	@Autowired
	private LoginService customerLogin;
	
	@PostMapping("/login")
	public ResponseEntity<String> logInCustomerOrRestaurant(@RequestBody LoginDTO dto) throws LoginException {
		
		String result = customerLogin.logIntoAccount(dto);	

		return new ResponseEntity<String>(result,HttpStatus.OK );
		
	}
	
	
	
	@PostMapping("/logout")
	public String logoutCustomerOrRestaurant(@RequestParam(required = false) String key) throws LoginException {
		return customerLogin.logOutFromAccount(key);
		
	}
	
	
	
}
