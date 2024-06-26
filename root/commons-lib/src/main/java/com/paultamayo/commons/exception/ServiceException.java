package com.paultamayo.commons.exception;

import lombok.Generated;

@Generated
public class ServiceException extends Exception {

	private static final long serialVersionUID = 342042000835287486L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Object... args) {
		super(String.format(message, args));
	}

	public ServiceException(Throwable cause, String message) {
		super(message, cause);
	}

	public ServiceException(Throwable cause, String message, Object... args) {
		super(String.format(message, args), cause);
	}

}
