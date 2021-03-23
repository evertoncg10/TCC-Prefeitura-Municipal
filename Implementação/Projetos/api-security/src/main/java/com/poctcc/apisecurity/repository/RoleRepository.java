package com.poctcc.apisecurity.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.poctcc.apisecurity.enums.ERole;
import com.poctcc.apisecurity.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
	
	Optional<Role> findByName(ERole name);

}
