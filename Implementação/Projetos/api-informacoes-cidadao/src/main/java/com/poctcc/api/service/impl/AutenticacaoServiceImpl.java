package com.poctcc.api.service.impl;

import javax.security.sasl.AuthenticationException;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.poctcc.api.enums.ApiServiceName;
import com.poctcc.api.service.AutenticacaoService;

@Service
public class AutenticacaoServiceImpl extends AbstractService implements AutenticacaoService {
	
	@Override
	public void validaAuth(String token) throws AuthenticationException {
		defineHeader(token);
		String url = defineUrl(ApiServiceName.AUTH);
		try {
			restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			throw new AuthenticationException();
		}
	}

}
