package com.poctcc.api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.poctcc.api.model.Pessoa;
import com.poctcc.api.model.PessoaFisica;
import com.poctcc.api.model.PessoaJuridica;

@Service
public class PessoaService {

	private static final String URL_API_SAFIM = "http://localhost:8090/pessoas/";

	public Pessoa findByPessoaSafim(String cpfCnpj) {
		RestTemplate restTemplate = new RestTemplate();
		Pessoa pessoa = null;
		if (cpfCnpj.length() == 11) {
			pessoa = restTemplate.getForObject(URL_API_SAFIM + cpfCnpj, PessoaFisica.class);

		} else if (cpfCnpj.length() == 14) {
			pessoa = restTemplate.getForObject(URL_API_SAFIM + cpfCnpj, PessoaJuridica.class);
		}

		return pessoa;
	}

}
