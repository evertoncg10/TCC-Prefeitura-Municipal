package com.poctcc.mock.api.controller;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poctcc.mock.api.service.IAutenticacaoService;
import com.poctcc.mock.api.service.IImovelSerivce;

@RestController
@RequestMapping("/imoveis")
public class ImovelController {
	
	@Autowired
	private IImovelSerivce imovelService;
	
	@Autowired
	private IAutenticacaoService autenticacaoService;
	
	@GetMapping("/{cpfCnpj}")
	public ResponseEntity<?> buscarPorCpfCnpj(@PathVariable String cpfCnpj, 
			@RequestHeader("Authorization") String token) {
		try {
			autenticacaoService.validaAuth(token);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acesso negado");
		}
		return ResponseEntity.ok(imovelService.findImovel(cpfCnpj));
	}

}
