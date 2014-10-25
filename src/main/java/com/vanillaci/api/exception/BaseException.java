package com.vanillaci.api.exception;

/**
 * @author Joel Johnson
 */
public abstract class BaseException extends RuntimeException {
	private final int errorCode;

	protected BaseException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	protected BaseException(int errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public final int getErrorCode() {
		return errorCode;
	}
}
