package com.poctcc.api.service;

import com.poctcc.api.exception.NotFoundException;
import com.poctcc.api.model.Pessoa;

public interface PessoaService {
	
	Pessoa findPersonByCpfOrCnpj(String cpfCnpj, String token) throws NotFoundException;
	
	Pessoa findPersonByEmail(String email, String token) throws NotFoundException;

}
