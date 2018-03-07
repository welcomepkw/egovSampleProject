package com.sample.common.exception;

public class BadReqeustException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadReqeustException() { super(); }

	public BadReqeustException(String message) { super(message); }

	public BadReqeustException(String message, Throwable cause) { super(message, cause); }

	public BadReqeustException(Throwable cause) { super(cause); }
}
