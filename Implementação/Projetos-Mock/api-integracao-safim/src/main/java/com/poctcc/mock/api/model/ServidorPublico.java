package com.poctcc.mock.api.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "servidor_publico")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ServidorPublico {

	@NotBlank(message = "A matrícula não pode ser vazia")
	private Long matricula;

	@NotBlank(message = "o cargo não pode ser vazio")
	@Size(max = 120)
	private String Cargo;
}
