package com.poctcc.mock.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.poctcc.mock.api.Enum.Estado;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "endereco")
public class Endereco {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "O logradouro não pode ser vazio")
	private String logradouro;

	@NotBlank(message = "O CEP não pode ser vazio")
	@Pattern(regexp = "[0-9]{8}", message = "O CEP possui formato inválido")
	@Column(length = 8)
	private String cep;

	private Integer numero;

	@Size(max = 100)
	private String bairro;

	@Size(max = 100)
	@NotBlank(message = "A Cidade não pode ser vazia")
	private String cidade;

	@NotNull
	private Estado estado;

//	@OneToMany(mappedBy = "endereco")
//	private Set<Pessoa> pessoas = new HashSet<>(0);

}
