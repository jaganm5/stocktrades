package com.hackerrank.stocktrades.exception;

public class RecordNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -1023979909347598610L;
	
	private String message;
	
	private String errorCode;

	public RecordNotFoundException() {
		super();
	}

	public RecordNotFoundException(String message, String errorCode, Throwable cause) {
		super(message, cause);
		this.message = message;
		this.errorCode = errorCode;
	}

	public RecordNotFoundException(String message, String errorCode) {
		super(message);
		this.message = message;
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
