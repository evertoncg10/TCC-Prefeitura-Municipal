package com.poc.tcc.api.service;

import javax.security.sasl.AuthenticationException;

public interface IAutenticacaoService {
	
	void validaAuth(String token) throws AuthenticationException;

}
