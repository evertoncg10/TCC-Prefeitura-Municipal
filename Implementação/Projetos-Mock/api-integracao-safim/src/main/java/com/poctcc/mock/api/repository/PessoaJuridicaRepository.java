package com.poctcc.mock.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poctcc.mock.api.model.PessoaJuridica;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {

	public PessoaJuridica findByCnpj(String cnpj);
	
	public PessoaJuridica findByEmail(String email);
}
