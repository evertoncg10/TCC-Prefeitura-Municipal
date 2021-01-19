package com.poctcc.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.poctcc.api.model.Pessoa;
import com.poctcc.api.model.PessoaFisica;
import com.poctcc.api.model.PessoaJuridica;

@Service
public class PessoaService {
	
	private String urlApiSafim;
	
	@Autowired
	private Environment env;

	public Pessoa findByPessoaSafim(String cpfCnpj) {
		RestTemplate restTemplate = new RestTemplate();
		urlApiSafim = getEndpointSafim();
		Pessoa pessoa = null;
		if (cpfCnpj.length() == 11) {
			pessoa = restTemplate.getForObject(urlApiSafim + cpfCnpj, PessoaFisica.class);

		} else if (cpfCnpj.length() == 14) {
			pessoa = restTemplate.getForObject(urlApiSafim + cpfCnpj, PessoaJuridica.class);
		}

		return pessoa;
	}
	
	private String getEndpointSafim() {
		String url = "";
		if(env.getProperty("spring.profiles.active").equalsIgnoreCase("development")) {
			url = env.getProperty("endpoints-safim.dev");
		} else {
			url = env.getProperty("endpoints-safim.prod");
		}
		return url;
	}

}
