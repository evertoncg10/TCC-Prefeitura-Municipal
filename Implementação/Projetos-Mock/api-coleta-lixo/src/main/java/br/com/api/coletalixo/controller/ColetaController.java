package br.com.api.coletalixo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.coletalixo.service.IColetaService;

@RestController
@RequestMapping("/v1/coletas")
public class ColetaController {
	
	@Autowired
	private IColetaService service;
	
	@GetMapping
	public ResponseEntity<?> listarTodos(@RequestParam String email, @RequestParam String token){
		return !"teste.implementacao.pucmg@gmail.com".equals(email) 
				|| !"8e776bf44b319ccc60f981e3288938744110b0370f24fef75fb3413f77a93699".equals(token) ?
				ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access") :
				ResponseEntity.ok(service.listarTodos());
	}

}
