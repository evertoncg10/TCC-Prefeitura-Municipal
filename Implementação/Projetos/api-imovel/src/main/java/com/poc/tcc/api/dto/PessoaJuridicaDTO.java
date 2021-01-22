package com.poc.tcc.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaJuridicaDTO extends PessoaDTO {

	private String cnpj;

	/**
	 * Está sendo considerado a Incrição Estadual no Formato de Minas Gerais.
	 * Format: "###.###.###/####"
	 */
	private String InscricaoEstadual;

	private String razaoSocial;

	private String nomeFantasia;
}
