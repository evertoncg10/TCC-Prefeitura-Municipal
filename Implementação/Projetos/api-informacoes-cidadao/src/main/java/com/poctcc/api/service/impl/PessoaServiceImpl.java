package com.poctcc.api.service.impl;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.poctcc.api.enums.ApiServiceName;
import com.poctcc.api.exception.NotFoundException;
import com.poctcc.api.model.Pessoa;
import com.poctcc.api.model.PessoaFisica;
import com.poctcc.api.model.PessoaJuridica;
import com.poctcc.api.service.PessoaService;

@Service
public class PessoaServiceImpl extends AbstractService implements PessoaService {
	
	private String urlSafim;
	
	@Override
	public Pessoa findPersonByCpfOrCnpj(String cpfCnpj, String token) throws NotFoundException {
		urlSafim = defineUrl(ApiServiceName.SAFIM);
		defineHeader(token);
		Class<?> clazz = null;
		if (cpfCnpj.length() == 11) {
			clazz = PessoaFisica.class;
		} else if (cpfCnpj.length() == 14) {
			clazz = PessoaJuridica.class;
		}
		ResponseEntity<?> dto = restTemplate.exchange(urlSafim + cpfCnpj, HttpMethod.GET, requestEntity, clazz);
		Pessoa pessoa = (Pessoa) dto.getBody();
		if(pessoa == null) 
			throw new NotFoundException();
		return pessoa;
	}

	@Override
	public Pessoa findPersonByEmail(String email, String token) throws NotFoundException {
		urlSafim = defineUrl(ApiServiceName.SAFIM);
		defineHeader(token);
		Pessoa pessoa = null;
		ResponseEntity<PessoaFisica> pessoaFisica = restTemplate.exchange(urlSafim + "?email=" + email, HttpMethod.GET, 
				requestEntity, PessoaFisica.class);
		if(pessoaFisica.getBody().getCpf() == null) {
			ResponseEntity<PessoaJuridica> pessoaJuridica = restTemplate.exchange(urlSafim + "?email=" + email, HttpMethod.GET, 
					requestEntity, PessoaJuridica.class);
			if(pessoaJuridica.getBody().getCnpj() == null)
				throw new NotFoundException();
			else
				pessoa = pessoaJuridica.getBody();
		} else 
			pessoa = pessoaFisica.getBody();
		return pessoa;
	}

}
