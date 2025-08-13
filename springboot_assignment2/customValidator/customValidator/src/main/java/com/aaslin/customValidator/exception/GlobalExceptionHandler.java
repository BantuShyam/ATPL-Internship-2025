package com.aaslin.customValidator.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,Object>> handleValidationExceptions(MethodArgumentNotValidException ex){
		Map<String,Object> body=new LinkedHashMap<>();
		body.put("status", HttpStatus.BAD_REQUEST.value());
		body.put("error","validation failed");
		
		Map<String,String> errors=new LinkedHashMap<>();
		ex.getBindingResult().getAllErrors().forEach(err->{
			String fieldName=err instanceof FieldError ? ((FieldError) err).getField() : err.getObjectName();
			errors.put(fieldName,err.getDefaultMessage());
		});		
		
		body.put("message", errors);
		return ResponseEntity.badRequest().body(body);
	}
}
