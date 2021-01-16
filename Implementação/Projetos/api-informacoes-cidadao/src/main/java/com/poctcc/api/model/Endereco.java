package com.poctcc.api.model;

import com.poctcc.api.enums.Estado;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Endereco {

	private long id;

	private String logradouro;

	private String cep;

	private Integer numero;

	private String bairro;

	private String cidade;

	private Estado estado;

//	@OneToMany(mappedBy = "endereco")
//	private Set<Pessoa> pessoas = new HashSet<>(0);

}