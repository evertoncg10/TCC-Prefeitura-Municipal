package com.poctcc.apisecurity.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import com.poctcc.apisecurity.enums.ERole;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Document(collection = "roles")
@Getter
@Setter
@RequiredArgsConstructor
public class Role {

	@Id
	private String id;
	
	@NonNull
	private ERole name;
}
