package com.poctcc.mock.api.service;

import java.util.List;

import com.poctcc.mock.api.model.Imovel;

public interface IImovelSerivce {
	
	List<Imovel> findImovel(String cpfCnpj);

}
