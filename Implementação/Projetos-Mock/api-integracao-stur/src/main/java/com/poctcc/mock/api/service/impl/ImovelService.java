package com.poctcc.mock.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.poctcc.mock.api.model.Imovel;
import com.poctcc.mock.api.repository.ImovelRepository;
import com.poctcc.mock.api.service.IImovelSerivce;

@Service
public class ImovelService implements IImovelSerivce {
	
	@Autowired
	private ImovelRepository imovelRepository;

	@Override
	public List<Imovel> findImovel(String cpfCnpj) {
		List<Imovel> imoveis = (cpfCnpj.length() == 11
				? buscarOptionalPorCpf(cpfCnpj) : buscarOptionalPorCnpj(cpfCnpj)).get();
		if(imoveis.isEmpty())
			throw new EmptyResultDataAccessException(1);
		
		imoveis.forEach(imovel -> imovel.calcularImposto());;
		return imoveis;
	}

	private Optional<List<Imovel>> buscarOptionalPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(imovelRepository.findByCpf(cpf));
	}
	
	private Optional<List<Imovel>> buscarOptionalPorCnpj(String cnpj) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(imovelRepository.findByCnpj(cnpj));
	}

}
