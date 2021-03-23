package com.poc.tcc.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {
	
	private String logradouro;
	private String cep;

	private Integer numero;

	private String bairro;

	private String cidade;

	private String estado;

}
