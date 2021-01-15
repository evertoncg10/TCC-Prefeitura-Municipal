package com.poctcc.mock.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poctcc.mock.api.model.Pessoa;
import com.poctcc.mock.api.model.PessoaFisica;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

	public Pessoa findByCpf(String cpf);
}
