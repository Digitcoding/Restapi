package com.fx.exception;

public class ExceptionResponse {

	private String errorMessage;

	private String errorCode;

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
