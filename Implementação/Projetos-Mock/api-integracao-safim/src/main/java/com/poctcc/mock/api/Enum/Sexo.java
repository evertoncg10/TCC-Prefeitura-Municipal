package com.poctcc.mock.api.Enum;

public enum Sexo {

	MASCULINO('M'), FEMININO('F');

	private final char valor;

	Sexo(char valorSexo) {
		valor = valorSexo;
	}

	public char getValor() {
		return valor;
	}
}
