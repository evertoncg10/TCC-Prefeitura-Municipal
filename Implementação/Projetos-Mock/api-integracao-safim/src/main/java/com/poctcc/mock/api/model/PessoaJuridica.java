package com.poctcc.mock.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "O CNPJ não pode ser vazio")
	@Pattern(regexp = "[0-9]{14}", message = "O CNPJ possui formato inválido")
	@Column(length = 14, nullable = false)
	private String cnpj;

	@NotBlank(message = "A Incrição Estadual não pode ser vazia")
	@Pattern(regexp = "(((\\d{3})\\.){2}\\d{3}/\\d{4})|(\\d{9}\\.\\d{2}-\\d{2})", message = "A Inscrição Estadual possui formato inválido")
	@Size(max = 120)
	/**
	 * Está sendo considerado a Incrição Estadual no Formato de Minas Gerais.
	 * Format: "###.###.###/####"
	 */
	private String InscricaoEstadual;

	@NotBlank(message = "A Razão Social não pode ser vazia")
	@Size(max = 120)
	private String razaoSocial;

	@NotBlank(message = "O Nome Fantasia não pode ser vazia")
	@Size(max = 120)
	private String nomeFantasia;

}
