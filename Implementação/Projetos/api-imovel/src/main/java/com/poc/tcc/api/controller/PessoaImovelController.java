package com.poc.tcc.api.controller;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.tcc.api.exception.NotFoundException;
import com.poc.tcc.api.service.IAutenticacaoService;
import com.poc.tcc.api.service.IPessoaImovelService;

@RestController
@CrossOrigin("*")
@RequestMapping("/pessoas")
public class PessoaImovelController {
	
	@Autowired
	private IPessoaImovelService pessoaImovelService;
	
	@Autowired
	private IAutenticacaoService autenticacaoService;
	
	@GetMapping("/{cpfCnpj}/imoveis")
	public ResponseEntity<?> getByCpfCnpj(@PathVariable String cpfCnpj, 
			@RequestHeader("Authorization") String token) throws NotFoundException {
		try {
			autenticacaoService.validaAuth(token);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Sua sessão expirou");
		}
		return ResponseEntity.ok(pessoaImovelService.getImoveisPessoa(cpfCnpj, token));
	}

}
