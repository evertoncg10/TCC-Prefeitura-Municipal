package com.poctcc.mock.api.enums;

public enum TipoPessoaFisica {
	SERVIDOR_PUBLICO("Servidor Público"), CIDADAO("Cidadão");

	private final String descricao;

	TipoPessoaFisica(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
