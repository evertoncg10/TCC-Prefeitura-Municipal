package com.poc.tcc.api.service.impl;

import javax.security.sasl.AuthenticationException;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.poc.tcc.api.enums.ApiServiceName;
import com.poc.tcc.api.service.IAutenticacaoService;

@Service
public class AutenticacaoServiceImpl extends AbstractService implements IAutenticacaoService {

	@Override
	public void validaAuth(String token) throws AuthenticationException {
		String url = defineUrl(ApiServiceName.AUTH);
		defineHeader(token);
		try {
			restTemplate.exchange(url, HttpMethod.GET, request, String.class);
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			throw new AuthenticationException();
		}
	}

}
