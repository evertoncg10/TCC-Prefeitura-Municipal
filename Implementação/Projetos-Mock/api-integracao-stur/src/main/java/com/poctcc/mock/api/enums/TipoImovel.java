package com.poctcc.mock.api.enums;

public enum TipoImovel {
	CASA('C'),
	APARTAMENTO('A'),
	SOBRADO('S'),
	EDICULA('E'),
	KITNET('K'),
	FLAT('F');
	
	private char value;
	
	private TipoImovel(char value) {
		this.value = value;
	}

	public char getValue() {
		return value;
	}
}
