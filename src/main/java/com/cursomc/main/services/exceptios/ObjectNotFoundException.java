package com.cursomc.main.services.exceptios;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}

	ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
