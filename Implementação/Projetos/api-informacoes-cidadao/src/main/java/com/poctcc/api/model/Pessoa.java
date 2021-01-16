package com.poctcc.api.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	private String telefone;

	private Endereco endereco;

	private String email;

}
