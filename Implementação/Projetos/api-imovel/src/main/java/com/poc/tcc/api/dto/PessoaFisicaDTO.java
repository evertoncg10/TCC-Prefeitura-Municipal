package com.poc.tcc.api.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaFisicaDTO extends PessoaDTO {
	
	private String cpf;

	private String nome;

	private LocalDate dataNascimento;

	private String sexo;

	private Long matricula;

	private String cargo;

	private String tipo;

}
