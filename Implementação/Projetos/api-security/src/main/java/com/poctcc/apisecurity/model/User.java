package com.poctcc.apisecurity.model;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Document(collection = "users")
@Getter
@Setter
@RequiredArgsConstructor
public class User {
	
	@Id
	private String id;
	
	@NotBlank
	@NonNull
	@Size(max = 14)
	private String username;
	
	@NotBlank
	@NonNull
	@Size(max = 120)
	private String password;
	
	@DBRef
	private Set<Role> roles = new HashSet<>();
}
