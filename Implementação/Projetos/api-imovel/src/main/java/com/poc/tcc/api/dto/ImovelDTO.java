package com.poc.tcc.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImovelDTO {
	
	private double areaConstruida;
	
	private double areaTotal;
	
	private double valorImovel;
	
	private String tipoImovel;
	
	private EnderecoDTO endereco;
	
	private double aliquota;
	
	private String tipoImposto;
	
	private String inscricaoMunicipal;
	
	private double valorImposto;

}
