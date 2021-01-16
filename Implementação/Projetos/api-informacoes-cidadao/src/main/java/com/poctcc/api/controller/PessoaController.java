package com.poctcc.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poctcc.api.model.Pessoa;
import com.poctcc.api.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	PessoaService pessoaService;

	@GetMapping("/{cpfCnpj}")
	public ResponseEntity<Pessoa> buscarPessoaPeloCpfCnpj(@PathVariable String cpfCnpj) {
		return ResponseEntity.ok(pessoaService.findByPessoaSafim(cpfCnpj));
	}

}
