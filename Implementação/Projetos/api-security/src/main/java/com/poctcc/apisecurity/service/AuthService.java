package com.poctcc.apisecurity.service;

import com.poctcc.apisecurity.payload.request.LoginRequest;
import com.poctcc.apisecurity.payload.request.SignupRequest;
import com.poctcc.apisecurity.payload.response.JwtResponse;
import com.poctcc.apisecurity.payload.response.MessageResponse;

public interface AuthService {
	
	JwtResponse signInUser(LoginRequest loginRequest);
	
	MessageResponse signUpUser(SignupRequest signupRequest);
	
	void signOutUser(String username);

}
