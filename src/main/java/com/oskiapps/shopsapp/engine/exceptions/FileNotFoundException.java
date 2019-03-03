package com.oskiapps.shopsapp.engine.exceptions;

public class FileNotFoundException extends RuntimeException {

	public FileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileNotFoundException(String message) {
		super(message);
	}

}
