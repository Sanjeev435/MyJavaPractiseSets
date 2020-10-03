package com.practise.exception;

public class CustomExcpOverrideRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomExcpOverrideRuntimeException(String message) {
        super(message);
    }
	
	public CustomExcpOverrideRuntimeException(String message, Exception ex) {
        super(message, ex);
    }
}
