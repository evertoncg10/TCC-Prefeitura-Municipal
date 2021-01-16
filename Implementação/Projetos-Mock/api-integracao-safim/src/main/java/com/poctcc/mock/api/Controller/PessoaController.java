package com.poctcc.mock.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poctcc.mock.api.model.Pessoa;
import com.poctcc.mock.api.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping("/{cpfCnpj}")
	public ResponseEntity<Pessoa> buscarPessoaPeloCpfCnpj(@PathVariable String cpfCnpj) {

		Pessoa pessoa = pessoaService.buscarPessoaPeloCpfCnpj(cpfCnpj);
		return ResponseEntity.ok(pessoa);
	}

}
