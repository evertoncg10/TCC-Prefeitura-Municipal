package br.com.api.coletalixo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.coletalixo.dto.ColetaDTO;
import br.com.api.coletalixo.entity.Coleta;
import br.com.api.coletalixo.repository.ColetaRepository;
import br.com.api.coletalixo.service.IColetaService;

@Service
public class ColetaService implements IColetaService {

	@Autowired
	private ColetaRepository repository;
	
	@Override
	public List<ColetaDTO> listarTodos() {
		return repository.findAll()
				.stream()
				.map(this::converteParaDto)
				.collect(Collectors.toList());
	}
	
	private ColetaDTO converteParaDto(Coleta coleta) {
		return new ModelMapper().map(coleta, ColetaDTO.class);
	}

}
