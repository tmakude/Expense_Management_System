package com.app.globalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.customeException.CustomeException;
import com.app.entity.State;

@RestControllerAdvice
public class GloableExceptionHandler {

	@ExceptionHandler(CustomeException.class)
	public ResponseEntity<String> CutomeExveptionHandler(CustomeException ex) {

		return new ResponseEntity<>(ex.getMessage() , HttpStatus.NOT_FOUND);

	}

}
