package com.poc.tcc.api.service.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.poc.tcc.api.dto.ImovelDTO;
import com.poc.tcc.api.dto.PessoaDTO;
import com.poc.tcc.api.dto.PessoaFisicaDTO;
import com.poc.tcc.api.dto.PessoaJuridicaDTO;
import com.poc.tcc.api.enums.ApiServiceName;
import com.poc.tcc.api.exception.NotFoundException;
import com.poc.tcc.api.service.IPessoaImovelService;

@Service
public class PessoaImovelService extends AbstractService implements IPessoaImovelService {

	@Override
	public PessoaDTO getImoveisPessoa(String cpfCnpj, String token) throws NotFoundException {
		// TODO Auto-generated method stub
		String urlStur = defineUrl(ApiServiceName.STUR);
		urlStur += cpfCnpj;
		defineHeader(token);
		PessoaDTO pessoaDTO = getPessoa(cpfCnpj, token);
		try {
			ResponseEntity<List<ImovelDTO>> response = 
				restTemplate.exchange(urlStur, HttpMethod.GET, 
						request, new ParameterizedTypeReference<List<ImovelDTO>>() {});
			pessoaDTO.setImoveis(response.getBody());
		} catch(HttpClientErrorException hcex) {
			pessoaDTO.setImoveis(null);
		}
		return pessoaDTO;
	}

	private PessoaDTO getPessoa(String cpfCnpj, String token) throws NotFoundException {
		try {
			String urlCidadao = defineUrl(ApiServiceName.CIDADAO);
			urlCidadao += cpfCnpj;
			Class<?> clazz = cpfCnpj.length() == 11 ? PessoaFisicaDTO.class : PessoaJuridicaDTO.class;
			ResponseEntity<?> dto = restTemplate.exchange(urlCidadao, HttpMethod.GET, request, clazz);
			return (PessoaDTO) dto.getBody();
		} catch(HttpClientErrorException hcex) {
			throw new NotFoundException();
		}
	}

}
