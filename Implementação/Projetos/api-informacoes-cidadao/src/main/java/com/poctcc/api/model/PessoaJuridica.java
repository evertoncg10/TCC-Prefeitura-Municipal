package com.poctcc.api.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class PessoaJuridica extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String cnpj;

	/**
	 * Está sendo considerado a Incrição Estadual no Formato de Minas Gerais.
	 * Format: "###.###.###/####"
	 */
	private String InscricaoEstadual;

	private String razaoSocial;

	private String nomeFantasia;

}
