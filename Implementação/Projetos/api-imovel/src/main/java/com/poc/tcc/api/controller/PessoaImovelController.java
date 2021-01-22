package com.poc.tcc.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.tcc.api.dto.PessoaDTO;
import com.poc.tcc.api.exception.NotFoundException;
import com.poc.tcc.api.service.IPessoaImovelService;

@RestController
@RequestMapping("/pessoas")
public class PessoaImovelController {
	
	@Autowired
	private IPessoaImovelService pessoaImovelService;
	
	@GetMapping("imoveis/{cpfCnpj}")
	public ResponseEntity<PessoaDTO> getByCpfCnpj(@PathVariable String cpfCnpj) throws NotFoundException {
		return ResponseEntity.ok(pessoaImovelService.getImoveisPessoa(cpfCnpj));
	}

}
