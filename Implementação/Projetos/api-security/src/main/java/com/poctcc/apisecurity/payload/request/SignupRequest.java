package com.poctcc.apisecurity.payload.request;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SignupRequest {

	@NotBlank
	@Size(min = 3, max = 100)
	private String username;
	
	@NotBlank
	@Size(min = 6, max = 40)
	private String password;
	
	private Set<String> roles;
}
