package com.cursomc.main.services.exceptios;

public class DataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataIntegrityException(String msg) {
		super(msg);
	}

	DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
