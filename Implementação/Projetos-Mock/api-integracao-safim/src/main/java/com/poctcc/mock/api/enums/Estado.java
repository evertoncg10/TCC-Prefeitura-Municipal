package com.poctcc.mock.api.enums;

public enum Estado {

	Acre("AC"), Alagoas("AL"), Amapá("AP"), Amazonas("AM"), Bahia("BA"), Ceará("CE"), DistritoFederal("DF"),
	EspíritoSanto("ES"), Goiás("GO"), Maranhão("MA"), MatoGrosso("MT"), MatoGrossoDoSul("MS"), MinasGerais("MG"),
	Pará("PA"), Paraíba("PB"), Paraná("PR"), Pernambuco("PE"), Piauí("PI"), RioDeJaneiro("RJ"), RioGrandeDoNorte("RN"),
	RioGrandeDoSul("RS"), Rondônia("RO"), Roraima("RR"), SantaCatarina("SC"), SãoPaulo("SP"), Sergipe("SE"),
	Tocantins("TO"),;

	private final String valor;

	Estado(String valorEstado) {
		valor = valorEstado;
	}

	public String getValor() {
		return valor;
	}
}
