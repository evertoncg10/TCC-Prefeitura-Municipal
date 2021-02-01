package com.poctcc.api.controller;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poctcc.api.exception.NotFoundException;
import com.poctcc.api.service.AutenticacaoService;
import com.poctcc.api.service.PessoaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	private AutenticacaoService autenticacaoService;

	@GetMapping("/{cpfCnpj}")
	public ResponseEntity<?> buscarPessoaPeloCpfCnpj(@PathVariable String cpfCnpj,
			@RequestHeader("Authorization") String token) throws NotFoundException {
		try {
			autenticacaoService.validaAuth(token);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acesso negado");
		}
		return ResponseEntity.ok(pessoaService.findPersonByCpfOrCnpj(cpfCnpj, token));
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscarPessoaPeloEmail(@RequestParam("email") String email, 
			@RequestHeader("Authorization") String token) throws NotFoundException {
		try {
			autenticacaoService.validaAuth(token);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acesso negado");
		}
		return ResponseEntity.ok(pessoaService.findPersonByEmail(email, token));
	}

}
