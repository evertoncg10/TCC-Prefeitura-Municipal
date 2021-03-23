package com.poctcc.apisecurity.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poctcc.apisecurity.payload.request.LoginRequest;
import com.poctcc.apisecurity.payload.request.SignupRequest;
import com.poctcc.apisecurity.repository.RoleRepository;
import com.poctcc.apisecurity.repository.UserRepository;
import com.poctcc.apisecurity.service.AuthService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/v1/api/auth", consumes = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {		
		return ResponseEntity.ok(authService.signInUser(loginRequest));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
		return ResponseEntity.ok(authService.signUpUser(signupRequest));
	}

}
