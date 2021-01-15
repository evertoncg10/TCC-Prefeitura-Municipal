package com.poctcc.mock.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.poctcc.mock.api.model.Pessoa;
import com.poctcc.mock.api.repository.PessoaFisicaRepository;
import com.poctcc.mock.api.repository.PessoaJuridicaRepository;

@Service
public class PessoaService {

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

}
