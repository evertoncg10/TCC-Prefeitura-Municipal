package com.poctcc.mock.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poctcc.mock.api.model.Imovel;
import com.poctcc.mock.api.service.IImovelSerivce;

@RestController
@RequestMapping("/imoveis")
public class ImovelController {
	
	@Autowired
	private IImovelSerivce imovelService;
	
	@GetMapping("/{cpfCnpj}")
	public ResponseEntity<List<Imovel>> buscarPorCpfCnpj(@PathVariable String cpfCnpj) {
		return ResponseEntity.ok(imovelService.findImovel(cpfCnpj));
	}

}
