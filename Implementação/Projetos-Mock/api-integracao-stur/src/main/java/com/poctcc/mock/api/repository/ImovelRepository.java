package com.poctcc.mock.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poctcc.mock.api.model.Imovel;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {
	
	List<Imovel> findByCpf(String cpf);
	
	List<Imovel> findByCnpj(String cnpj);

}
