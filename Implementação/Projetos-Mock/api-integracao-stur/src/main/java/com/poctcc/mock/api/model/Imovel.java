package com.poctcc.mock.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.poctcc.mock.api.enums.TipoImovel;
import com.poctcc.mock.api.enums.TipoImposto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="imovel")
public class Imovel implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Pattern(regexp = "[0-9]{11}", message = "O CPF possui formato inválido")
	@Column(length = 11, nullable = true)
	private String cpf;
	
	@Pattern(regexp = "[0-9]{14}", message = "O CNPJ possui formato inválido")
	@Column(length = 14, nullable = true)
	private String cnpj;
	
	@NotNull
	@Digits(integer = 10, fraction = 2)
	private double areaConstruida;
	
	@NotNull
	@Digits(integer = 10, fraction = 2)
	private double areaTotal;
	
	@NotNull
	@Digits(integer = 10, fraction = 2)
	private double valorImovel;
	
	@Enumerated(EnumType.STRING)
	private TipoImovel tipoImovel;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
	@NotNull
	@Digits(integer = 10, fraction = 2)
	private double aliquota;
	
	@Enumerated(EnumType.STRING)
	private TipoImposto tipoImposto;
	
	@NotBlank(message = "Obrigatório informar Inscrição Municipal")
	private String inscricaoMunicipal;
	

}
