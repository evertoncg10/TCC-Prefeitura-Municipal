package com.poc.tcc.api.service;

import com.poc.tcc.api.dto.PessoaDTO;
import com.poc.tcc.api.exception.NotFoundException;

public interface IPessoaImovelService {
	
	PessoaDTO getImoveisPessoa(String cpfCnpj, String token) throws NotFoundException;

}
