package com.poctcc.apisecurity.payload.response;

import java.util.List;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class JwtResponse {

	@NonNull
	private String token;
	
	private String typeToken = "Bearer";
	
	@NonNull
	private String id;
	
	@NonNull
	private String username;
	
	@NonNull
	private List<String> roles;
	
	
}
