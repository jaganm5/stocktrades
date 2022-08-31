package com.hackerrank.stocktrades.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hackerrank.stocktrades.dto.ErrorResponse;
import com.hackerrank.stocktrades.exception.RecordNotFoundException;

@ControllerAdvice
public class StockTradeExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleRecordNotFoundException(RecordNotFoundException exception){
		ErrorResponse response = new ErrorResponse();
		response.setErrorCode(exception.getErrorCode());
		response.setMessage(exception.getMessage());
		HttpStatus status = HttpStatus.NOT_FOUND;
		return new ResponseEntity<ErrorResponse>(response, status);
	}

}
