package com.poctcc.mock.api.service;

import com.poctcc.mock.api.model.Pessoa;

public interface PessoaService {
	
	Pessoa buscarPessoaPeloCpfCnpj(String cpfCnpj);
	
	Pessoa buscarPessoaPeloEmail(String email);

}
