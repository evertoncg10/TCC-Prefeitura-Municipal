package br.com.api.coletalixo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.coletalixo.dto.ColetaDTO;
import br.com.api.coletalixo.service.IColetaService;

@RestController
@RequestMapping("/v1/coletas")
public class ColetaController {
	
	@Autowired
	private IColetaService service;
	
	@GetMapping
	public List<ColetaDTO> listarTodos(){
		return service.listarTodos();
	}

}
