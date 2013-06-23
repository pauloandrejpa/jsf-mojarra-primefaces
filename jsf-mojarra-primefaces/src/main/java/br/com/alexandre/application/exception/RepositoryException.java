package br.com.alexandre.application.exception;

public class RepositoryException extends MyAppException {

	private static final long serialVersionUID = 9206048478079900093L;

	public RepositoryException() {
	}

	public RepositoryException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public RepositoryException(final String message) {
		super(message);
	}

	public RepositoryException(final Throwable cause) {
		super(cause);
	}

}
