package com.caad.app.service.user;

public class UserServiceException extends RuntimeException {
	
	/*
	 * Clase para manejar Excepciones personalizadas en los servicios de usuario
	 */
	
	private static final long serialVersionUID = 1L;

	public UserServiceException(String message) {
		super(message);
	}
	
	public UserServiceException(String message, Throwable cause) {
		super(message,cause);
	}

}
