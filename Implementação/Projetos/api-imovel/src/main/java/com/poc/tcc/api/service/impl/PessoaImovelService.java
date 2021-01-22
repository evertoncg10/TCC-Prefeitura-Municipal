package com.poc.tcc.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.poc.tcc.api.dto.ImovelDTO;
import com.poc.tcc.api.dto.PessoaDTO;
import com.poc.tcc.api.dto.PessoaFisicaDTO;
import com.poc.tcc.api.dto.PessoaJuridicaDTO;
import com.poc.tcc.api.exception.NotFoundException;
import com.poc.tcc.api.service.IPessoaImovelService;

@Service
public class PessoaImovelService implements IPessoaImovelService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment env;
	
	private String urlSafim;
	
	private String urlStur;

	@Override
	public PessoaDTO getImoveisPessoa(String cpfCnpj) throws NotFoundException {
		// TODO Auto-generated method stub
		defineEndpoints();
		PessoaDTO pessoaDTO = getPessoa(cpfCnpj);
		try {
			ResponseEntity<List<ImovelDTO>> response = 
				restTemplate.exchange(urlStur + cpfCnpj, HttpMethod.GET, 
						null, new ParameterizedTypeReference<List<ImovelDTO>>() {});
			pessoaDTO.setImoveis(response.getBody());
		} catch(HttpClientErrorException hcex) {
			pessoaDTO.setImoveis(null);
		}
		return pessoaDTO;
	}
	
	private PessoaDTO getPessoa(String cpfCnpj) throws NotFoundException {
		try {
			PessoaDTO dto = cpfCnpj.length() == 11
					? restTemplate.getForObject(urlSafim + cpfCnpj, PessoaFisicaDTO.class) 
					: restTemplate.getForObject(urlSafim + cpfCnpj, PessoaJuridicaDTO.class);
			return dto;
		} catch(HttpClientErrorException hcex) {
			throw new NotFoundException();
		}
	}

	private void defineEndpoints() {
		if(env.getProperty("spring.profiles.active").equalsIgnoreCase("development")) {
			urlSafim = env.getProperty("endpoints-safim.dev");
			urlStur = env.getProperty("endpoints-stur.dev");
		} else {
			urlSafim = env.getProperty("endpoints-safim.prod");
			urlStur = env.getProperty("endpoints-stur.prod");
		}
	}

}
