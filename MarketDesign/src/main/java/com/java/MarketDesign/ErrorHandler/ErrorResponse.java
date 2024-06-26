package com.java.MarketDesign.ErrorHandler;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	private HttpStatus status;
	private String description ;
	private String message;
}
