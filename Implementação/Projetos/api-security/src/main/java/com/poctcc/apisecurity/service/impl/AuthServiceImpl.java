package com.poctcc.apisecurity.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.poctcc.apisecurity.enums.ERole;
import com.poctcc.apisecurity.jwt.JwtUtils;
import com.poctcc.apisecurity.model.Role;
import com.poctcc.apisecurity.model.User;
import com.poctcc.apisecurity.payload.request.LoginRequest;
import com.poctcc.apisecurity.payload.request.SignupRequest;
import com.poctcc.apisecurity.payload.response.JwtResponse;
import com.poctcc.apisecurity.payload.response.MessageResponse;
import com.poctcc.apisecurity.repository.RoleRepository;
import com.poctcc.apisecurity.repository.UserRepository;
import com.poctcc.apisecurity.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private AuthenticationManager authenticationManager;
		
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public JwtResponse signInUser(LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		return new JwtResponse(jwt, 
				 userDetails.getId(),
				 userDetails.getUsername(),
				 roles);
	}

	@Override
	public void signOutUser(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public MessageResponse signUpUser(SignupRequest signupRequest) {
		if(userRepository.existsByUsername(signupRequest.getUsername())) {
			return new MessageResponse("Erro: E-mail já cadastrado");
		}
		
		User user = new User(signupRequest.getUsername(),
							 encoder.encode(signupRequest.getPassword()));
		
		Set<String> strRoles = signupRequest.getRoles();
		Set<Role> roles = new HashSet<>();
		
		if(strRoles == null) {
			Role roleUser = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Erro: Perfil não encontrado"));
			roles.add(roleUser);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role roleAdmin = roleRepository.findByName(ERole.ROLE_ADMIN)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found"));
					roles.add(roleAdmin);
					break;
				case "mod":
					Role roleModerator = roleRepository.findByName(ERole.ROLE_MODERATOR)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found"));
					roles.add(roleModerator);

				default:
					Role roleUser = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found"));
					roles.add(roleUser);
					break;
				}
			});
		}
		
		user.setRoles(roles);
		userRepository.save(user);
		return new MessageResponse("Usuário cadastrado com sucesso");
	}

}
