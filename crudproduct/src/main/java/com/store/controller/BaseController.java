package com.store.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//Base
public class BaseController {

	public ResponseEntity<Object> buildResponseEntityCustomMessage(HttpStatus status, String errorMessage){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Error", errorMessage);
		return new ResponseEntity<>(errorMessage, headers, status);
	}
}
