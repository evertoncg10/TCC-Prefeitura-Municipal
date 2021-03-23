package com.poctcc.mock.api.service;

import javax.security.sasl.AuthenticationException;

public interface IAutenticacaoService {
	
	void validaAuth(String token) throws AuthenticationException;

}
