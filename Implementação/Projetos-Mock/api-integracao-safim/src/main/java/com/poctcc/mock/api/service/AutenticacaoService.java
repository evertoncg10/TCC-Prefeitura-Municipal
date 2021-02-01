package com.poctcc.mock.api.service;

import javax.security.sasl.AuthenticationException;

public interface AutenticacaoService {
	
	void validaAuth(String token) throws AuthenticationException;

}
