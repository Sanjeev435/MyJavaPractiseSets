package com.practise.exception;

public class CustomExcpOverrideException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomExcpOverrideException(String message) {
        super(message);
    }
	
	public CustomExcpOverrideException(String message, Exception ex) {
        super(message, ex);
    }
}
