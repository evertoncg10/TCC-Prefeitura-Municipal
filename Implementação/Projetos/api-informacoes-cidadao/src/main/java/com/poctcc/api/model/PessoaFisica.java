package com.poctcc.api.model;

import java.time.LocalDate;

import com.poctcc.api.enums.Sexo;
import com.poctcc.api.enums.TipoPessoaFisica;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)

public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String cpf;

	private String nome;

	private LocalDate dataNascimento;

	private Sexo sexo;

	private Long matricula;

	private String cargo;

	private TipoPessoaFisica tipo;
}
