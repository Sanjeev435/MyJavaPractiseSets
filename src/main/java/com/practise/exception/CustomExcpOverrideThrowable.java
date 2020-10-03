package com.practise.exception;

public class CustomExcpOverrideThrowable extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomExcpOverrideThrowable(String message) {
        super(message);
    }
	
	public CustomExcpOverrideThrowable(String message, Exception ex) {
        super(message, ex);
    }
}
