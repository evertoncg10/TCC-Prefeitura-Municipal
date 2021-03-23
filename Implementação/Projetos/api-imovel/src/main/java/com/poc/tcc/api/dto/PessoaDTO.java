package com.poc.tcc.api.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDTO {
	
	private long id;

	private String telefone;

	private EnderecoDTO endereco;

	private String email;
	
	private List<ImovelDTO> imoveis;
}
