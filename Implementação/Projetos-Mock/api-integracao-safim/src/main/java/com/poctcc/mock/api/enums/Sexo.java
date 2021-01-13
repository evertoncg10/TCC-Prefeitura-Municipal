package com.poctcc.mock.api.enums;

public enum Sexo {

	MASCULINO('M', "Masculino"), FEMININO('F', "Feminino");

	private final char sigla;
	private final String descricao;

	Sexo(char sigla, String descricao) {
		this.sigla = sigla;
		this.descricao = descricao;
	}

	public char getSigla() {
		return sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public boolean sameOf(char sigla) {
		return String.valueOf(this.sigla).equalsIgnoreCase(String.valueOf(sigla));
	}

	public static Sexo of(char sigla) {
		for (Sexo sexo : values()) {
			if (sexo.sameOf(sigla)) {
				return sexo;
			}
		}
		return null;
	}

}
