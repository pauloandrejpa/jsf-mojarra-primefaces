package br.com.alexandre.application.exception;

public class ServiceException extends MyAppException {

	private static final long serialVersionUID = -1788719085525765535L;

	public ServiceException() {
	}

	public ServiceException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ServiceException(final String message) {
		super(message);
	}

	public ServiceException(final Throwable cause) {
		super(cause);
	}

}
