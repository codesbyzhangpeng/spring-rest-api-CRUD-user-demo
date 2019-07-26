package com.zhangpeng.springbootrest;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedRepsonseEntityExceptionHandler 
					extends ResponseEntityExceptionHandler {
		
	@ExceptionHandler
	protected ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionResponse exceptionResponse =	new ExceptionResponse(new Date(),ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, status.NOT_FOUND);
	}

	
	@ExceptionHandler
	protected ResponseEntity<Object> handleAllException(Exception ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionResponse exceptionResponse =	new ExceptionResponse(new Date(),ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, status.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	@ExceptionHandler
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ExceptionResponse exceptionResponse =	new ExceptionResponse(new Date(),ex.getMessage(), ex.getBindingResult().toString());
		
		return new ResponseEntity<>(exceptionResponse, status.BAD_REQUEST);
	}

}
