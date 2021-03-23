package com.poctcc.apisecurity.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.poctcc.apisecurity.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	Optional<User> findByUsername(String username);
	
	Boolean existsByUsername(String username);

}
