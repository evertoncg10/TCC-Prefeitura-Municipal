package com.poctcc.api.service;

import javax.security.sasl.AuthenticationException;

public interface AutenticacaoService {
	
	void validaAuth(String token) throws AuthenticationException;

}
