package com.poctcc.mock.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.poctcc.mock.api.model.Pessoa;
import com.poctcc.mock.api.repository.PessoaFisicaRepository;
import com.poctcc.mock.api.repository.PessoaJuridicaRepository;
import com.poctcc.mock.api.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaFisicaRepository pessoaFisicaRepository;

	@Autowired
	private PessoaJuridicaRepository pessoajuridicaRepository;

	public Pessoa buscarPessoaPeloCpfCnpj(String cpfCnpj) {
		Optional<Pessoa> optionalPessoa = null;
		if (cpfCnpj.length() == 11) {
			optionalPessoa = this.buscarPessoaFisica(cpfCnpj);
		} else if (cpfCnpj.length() == 14) {
			optionalPessoa = this.buscarPessoaJuridica(cpfCnpj);
		}

		Pessoa pessoa = optionalPessoa.orElseThrow(() -> new EmptyResultDataAccessException(1));

		return pessoa;
	}

	private Optional<Pessoa> buscarPessoaFisica(String cpf) {
		return Optional.ofNullable(pessoaFisicaRepository.findByCpf(cpf));
	}

	private Optional<Pessoa> buscarPessoaJuridica(String cnpj) {
		return Optional.ofNullable(pessoajuridicaRepository.findByCnpj(cnpj));
	}

	@Override
	public Pessoa buscarPessoaPeloEmail(String email) {
		Pessoa pessoa = Optional.ofNullable(pessoaFisicaRepository.findByEmail(email))
				.orElse(pessoajuridicaRepository.findByEmail(email));
		if(pessoa == null)
			throw new EmptyResultDataAccessException(1);
		return pessoa;
	}

}
