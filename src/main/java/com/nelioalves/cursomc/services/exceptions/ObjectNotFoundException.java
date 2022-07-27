package com.nelioalves.cursomc.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public static final String OBJ_NAO_ENCONTRADO = "There is no category with this id, plaese try another one";
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}

}
