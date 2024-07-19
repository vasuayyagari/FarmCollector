package com.farm.collector.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.farm.collector.model.ApiResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(FarmException.class)
	public ResponseEntity<ApiResponse> farmExceptionHandler(FarmException exception) {
		return new ResponseEntity<>(new ApiResponse(exception.getErrorMessage()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse> genericExceptionHandler(Exception exception) {
		return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MissingRequestHeaderException.class)
	public ResponseEntity<ApiResponse> MissingRequestHeaderExceptionHandler(MissingRequestHeaderException exception) {
		return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<ApiResponse> MissingServletRequestParameterExceptionHandler(
			MissingServletRequestParameterException exception) {
		return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ApiResponse> HttpRequestMethodNotSupportedExceptionHandler(
			HttpRequestMethodNotSupportedException exception) {
		return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<ApiResponse> HttpMediaTypeNotSupportedExceptionHandler(
			HttpMediaTypeNotSupportedException exception) {
		return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

}
