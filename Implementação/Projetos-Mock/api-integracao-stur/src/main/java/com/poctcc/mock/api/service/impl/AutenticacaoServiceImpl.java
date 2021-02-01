package com.poctcc.mock.api.service.impl;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.poctcc.mock.api.service.IAutenticacaoService;

@Service
public class AutenticacaoServiceImpl implements IAutenticacaoService {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void validaAuth(String token) throws AuthenticationException {
		String url = "";
		if(env.getProperty("spring.profiles.active").equalsIgnoreCase("development")) {
			url = env.getProperty("endpoints-auth.dev");
		} else {
			url = env.getProperty("endpoints-auth.prod");
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", token);
		HttpEntity<String> req = new HttpEntity<String>(headers);
		try {
			restTemplate.exchange(url, HttpMethod.GET, req, String.class);
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			throw new AuthenticationException();
		}
	}

}
