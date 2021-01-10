package com.poctcc.mock.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.poctcc.mock.api.enums.Sexo;
import com.poctcc.mock.api.enums.TipoPessoaFisica;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "O CPF não pode ser vazio")
	@Pattern(regexp = "[0-9]{11}", message = "O CPF possui formato inválido")
	@Column(length = 11, nullable = false)
	private String cpf;

	@NotBlank(message = "O Nome não pode ser vazio")
	@Size(max = 120)
	private String nome;

	@NotNull
	private LocalDate dataNascimento;

	@NotNull
	private Sexo sexo;
	
	private Long matricula;

	@Size(max = 120)
	private String cargo;
	
	@Enumerated
	private TipoPessoaFisica tipo;
}
