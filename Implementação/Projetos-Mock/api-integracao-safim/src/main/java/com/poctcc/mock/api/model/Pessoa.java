package com.poctcc.mock.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "A telefone não pode ser vazio")
	@Pattern(regexp = "[0-9]{10,11}", message = "O telefone possui formato inválido")
	@Column(length = 11, nullable = false)
	private String telefone;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@NotBlank(message = "O E-mail não pode ser vazio")
	@Size(max = 60, message = "O E-mail é muito grande")
	@Email(message = "O E-mail é inválido")
	private String email;
}
