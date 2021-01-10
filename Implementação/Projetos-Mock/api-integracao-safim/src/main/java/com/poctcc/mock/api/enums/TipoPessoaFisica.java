package com.poctcc.mock.api.enums;

public enum TipoPessoaFisica {
	SERVIDOR_PUBLICO('S'),
	CIDADAO('C');
	
	private final char valor;

	TipoPessoaFisica(char valor) {
		this.valor = valor;
	}

	public char getValor() {
		return valor;
	}
}
