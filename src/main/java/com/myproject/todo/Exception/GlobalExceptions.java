package com.myproject.todo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {

	@ExceptionHandler(NoUserFound.class)
	public ResponseEntity<String> NoUser(NoUserFound exception){	  
		return new ResponseEntity<String> (exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class) 
	public HttpStatus globalException(){
		return (HttpStatus.INTERNAL_SERVER_ERROR); 
	}
	
}