package com.practise.exception;

public class TestException {

	public static void main(String[] args) throws Throwable {
		try {
			throwsRuntimeCustomExcption();
		} catch (Throwable ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}

	private static void throwsRuntimeCustomExcption() throws Throwable {
		try {
			// throw new IOException("This is a checked exception."); // This will be catch
			// by CustomExcpOverrideRuntimeException
			// throw new NullPointerException("This is a runtime exception."); // This will
			// be catch by CustomExcpOverrideException
			throw new Error("This is an error."); // This will be catch by CustomExcpOverrideThrowable
		} catch (RuntimeException ex) {
			throw new CustomExcpOverrideRuntimeException(
					ex.getMessage() + " Throws CustomExcpOverrideRuntimeException");
		} catch (Exception ex) {
			throw new CustomExcpOverrideException(ex.getMessage() + " Throws CustomExcpOverrideException");
		} catch (Throwable ex) {
			throw new CustomExcpOverrideThrowable(ex.getMessage() + " Throws CustomExcpOverrideThrowable");
		}
	}

}
