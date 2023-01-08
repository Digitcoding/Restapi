package com.fx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler  {

	/**
	 * 
	 */
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ExceptionResponse>  handleResourceNotFound(DataNotFoundException exception) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.setErrorCode("REST-API-404");

		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleUserNotExceptiom(UserNotFoundException exception) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.setErrorCode("REST-API-4043");

		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}

	
	

}
