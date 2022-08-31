package com.hackerrank.stocktrades.dto;

import java.io.Serializable;

public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 2543122727452973170L;
	
	private String errorCode;
	
	private String message;	

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
