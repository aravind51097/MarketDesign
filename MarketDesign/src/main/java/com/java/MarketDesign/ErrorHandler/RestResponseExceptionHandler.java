package com.java.MarketDesign.ErrorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@ResponseStatus
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler{

	
		
	@ExceptionHandler(MarketNotFoundException.class)
	private ResponseEntity<ErrorResponse> errorMessage(MarketNotFoundException exception) {
		
		ErrorResponse errorMessage=
				new ErrorResponse(HttpStatus.NOT_FOUND,"Hello you got a Error !",exception.getMessage());
		
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
		
	}
	@ExceptionHandler(ModelNotFoundException.class)
	private ResponseEntity<ErrorResponse> errorMessageForModelClass(ModelNotFoundException exception){
		
		ErrorResponse errorMessageForModel=new ErrorResponse(HttpStatus.NOT_FOUND,
				"Hello you got a Error" , exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessageForModel);
		
	}
	
	@ExceptionHandler(UpdateModelException.class)
	private ResponseEntity<ErrorResponse> errorMessageforUpdateModel(UpdateModelException exception){
		
		ErrorResponse errorMessage=new ErrorResponse(HttpStatus.NOT_FOUND,"Hello you got a Error "
				,exception.getMessage());
		
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
	}
}
