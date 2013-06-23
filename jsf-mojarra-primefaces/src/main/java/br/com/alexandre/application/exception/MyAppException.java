package br.com.alexandre.application.exception;

public abstract class MyAppException extends RuntimeException {

	private static final long serialVersionUID = -3660631104091305353L;

	public MyAppException() {
		super();
	}

	public MyAppException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public MyAppException(final String message) {
		super(message);
	}

	public MyAppException(final Throwable cause) {
		super(cause);
	}
	
}
