package com.zayar.practice.api.controller.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zayar.practice.api.model.RegistrationBody;
import com.zayar.practice.exception.UserAlreadyExistsException;
import com.zayar.practice.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	private UserService userService;
	
	public AuthenticationController(UserService userService) {
		this.userService=userService;
	}

	@PostMapping("/register")
	public ResponseEntity registerUser(@Valid @RequestBody RegistrationBody registrationBody) {
		
		try {
			userService.registerUser(registrationBody);
			return ResponseEntity.ok().build();
			
		}catch(UserAlreadyExistsException ex) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}
