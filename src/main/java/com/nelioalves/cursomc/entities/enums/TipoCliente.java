package com.nelioalves.cursomc.entities.enums;

import com.nelioalves.cursomc.entities.exceptions.TipoClienteException;

public enum TipoCliente {

	PESSOA_FISICA(1),
	PESSOA_JURIDICA(2);
	
	private Integer codigo;
	
	TipoCliente(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public static TipoCliente valueOf(Integer tipo) {
		for(TipoCliente tipoCliente : TipoCliente.values()) {
			if(tipoCliente.getCodigo().equals(tipo)) {
				return tipoCliente;
			}
		}
		throw new TipoClienteException("Invalid code for TipoCliente, please try another one!");
	}
}
